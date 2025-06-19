package com.mycompany.project_spring.converter;


import com.mycompany.project_spring.entity.DetailEntity;
import com.mycompany.project_spring.modal.Details;
import org.springframework.stereotype.Component;

@Component
public class DetailConverter {
    
    public DetailEntity convertDetailToEntity(Details details){
        DetailEntity de=new DetailEntity();
        de.setName(details.getName());
        de.setDescription(details.getDescription());
        de.setPrice(details.getPrice());
        return  de;
    }

    public Details  convertEntityToDetail(DetailEntity detailEntity){
       Details details=new Details();
       details.setId(detailEntity.getId());
        details.setName(detailEntity.getName());
        details.setDescription(detailEntity.getDescription());
        details.setPrice(detailEntity.getPrice());
        return  details;

    }
    
}
