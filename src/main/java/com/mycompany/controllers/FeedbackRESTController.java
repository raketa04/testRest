/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.dto.FeedbackDto;
import com.mycompany.resurse.Feedback;
import com.mycompany.service.FeedbackService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("feedback")
public class FeedbackRESTController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private  FeedbackService feedbackService;
    
    @JsonView(FeedbackDto.getFeedback.class)
    @RequestMapping(value ="add", method = RequestMethod.POST)
    public ResponseEntity<FeedbackDto> addFeedback(@Validated(FeedbackDto.addFeedback.class)@RequestBody FeedbackDto feedbackDto) {
        Feedback result = feedbackService.save(modelMapper.map(feedbackDto, Feedback.class));
        return new ResponseEntity<>(modelMapper.map(result, FeedbackDto.class), HttpStatus.OK);
    }
    
    @JsonView(FeedbackDto.getFeedback.class)
    @RequestMapping(value ="update", method = RequestMethod.PUT)
    public ResponseEntity<FeedbackDto> updateFeedback(@Validated(FeedbackDto.editFeedback.class) @RequestBody FeedbackDto feedbackDto) {
        Feedback result = feedbackService.save(modelMapper.map(feedbackDto, Feedback.class));
        return new ResponseEntity<>(modelMapper.map(result, FeedbackDto.class), HttpStatus.OK);
    }
    
    @JsonView(FeedbackDto.getFeedback.class)
    @RequestMapping(value = "placement/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<FeedbackDto>> getFeedbackByPlacement(@PathVariable int id) {
         List<FeedbackDto> list = feedbackService.findAll(id).stream()
                .map(authority -> modelMapper.map(authority ,FeedbackDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "placement/{id}/rating", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Float> getRatingByPlacement(@PathVariable int id) {
        return new ResponseEntity<>(feedbackService.findRating(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "account/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Float> getFeedbackByAccount(@PathVariable int id) {
        return new ResponseEntity<>(feedbackService.findRating(id), HttpStatus.OK);
    }
    
}
