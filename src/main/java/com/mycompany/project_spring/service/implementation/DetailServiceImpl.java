package com.mycompany.project_spring.service.implementation;

import com.mycompany.project_spring.converter.DetailConverter;
import com.mycompany.project_spring.entity.DetailEntity;
import com.mycompany.project_spring.modal.Details;
import com.mycompany.project_spring.repository.DetailRepository;
import com.mycompany.project_spring.service.detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetailServiceImpl implements detailsService {

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private DetailConverter detailConverter;

    @Override
    public Details saveDetails(Details details) {
        DetailEntity de = detailConverter.convertDetailToEntity(details);
        de = detailRepository.save(de);
        details = detailConverter.convertEntityToDetail(de);
        return details;
    }

    @Override
    public List<Details> getAllDetails() {
        List<DetailEntity> listOfProps = (List<DetailEntity>) detailRepository.findAll();
        List<Details> detailList = new ArrayList<>();
        for (DetailEntity de : listOfProps) {
            Details detail = detailConverter.convertEntityToDetail(de);
            detailList.add(detail);
        }
        return detailList;
    }
    @Override
    public Details updateDetails(Details details, Long id){
        Optional<DetailEntity> optEn=detailRepository.findById(id);
        Details detail=null;
        if(optEn.isPresent()){
            DetailEntity de=optEn.get();//data form database
            de.setName(details.getName());
            de.setDescription(details.getDescription());
            de.setPrice(details.getPrice());
            detail=detailConverter.convertEntityToDetail(de);
            detailRepository.save(de);
        }
        return  detail;
    }

    @Override
    public  void deleteDetail(Long id){
        detailRepository.deleteById(id);
    }


    @Override
    public Details updateDetailPrice(Details details, Long id){
        System.out.println(">> Service - ID: " + id);
        System.out.println(">> Service - New Price: " + details.getPrice());

        Optional<DetailEntity> optEn = detailRepository.findById(id);
        if (optEn.isPresent()) {
            DetailEntity de = optEn.get();
            de.setPrice(details.getPrice());
            detailRepository.save(de);
            return detailConverter.convertEntityToDetail(de);
        } else {
            System.out.println(">> Record not found with ID: " + id);
            return null;
        }
    }

}
