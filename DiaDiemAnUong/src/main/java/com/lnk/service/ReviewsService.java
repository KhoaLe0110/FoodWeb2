/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lnk.service;

import com.lnk.pojo.Reviews;
import java.util.List;

/**
 *
 * @author Jackie's PC
 */
public interface ReviewsService {
     List<Reviews> getReviews(int storesId,int page);
    Reviews addReviews(Reviews c);
}
