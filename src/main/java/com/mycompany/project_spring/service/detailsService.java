package com.mycompany.project_spring.service;

import com.mycompany.project_spring.modal.Details;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface detailsService {
     Details saveDetails(Details details);
     List<Details> getAllDetails();
     Details updateDetails(Details details, Long id);
     Details updateDetailPrice(Details details,Long id);
     void deleteDetail(Long id);
}
