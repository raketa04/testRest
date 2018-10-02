/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonView;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADMIN
 */
public class AvatarDto {
     public interface addAvatar {
    }
    
    public interface deleteAvatar{
    }
    
    public interface getAvatar {
    }
    
    @NotNull(groups = {deleteAvatar.class})
    @JsonView({getAvatar.class,AccountDto.token.class,PlacementDto.getPlacmentSearach.class,FeedbackDto.getFeedbackOrder.class})
    private Integer idAvatar = null;

    public AvatarDto() {
    }

    public AvatarDto(Integer idAvatar) {
        this.idAvatar = idAvatar;
    }

    public Integer getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(Integer idAvatar) {
        this.idAvatar = idAvatar;
    }
}
