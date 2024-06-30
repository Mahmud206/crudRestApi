package com.dbh.restapi.service.Impl;

import com.dbh.restapi.dto.BranchDto;
import com.dbh.restapi.entity.BranchEntity;
import com.dbh.restapi.exception.ResourceNotFoundException;
import com.dbh.restapi.repository.BranchRepo;
import com.dbh.restapi.service.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class BranchImpl implements BranchService {


    private BranchRepo branchrepo;
    private ModelMapper mapper;

             // Branchimpl Constructor ...
    public BranchImpl(BranchRepo branchrepo,ModelMapper mapper) {
        this.branchrepo = branchrepo;
        this.mapper = mapper;
    }


    public List<BranchDto> GetBranch() {
        List<BranchEntity> branchentity = branchrepo.findAll();
        return  branchentity.stream().map
                (branchentity1 -> mapToDTO(branchentity1)).collect(Collectors.toList());

    }

   /* @Override
    public List<BranchDto> GetBranch(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<BranchEntity> branchEntities= branchrepo.findAll(pageable);

        // get content for page object
        List<BranchEntity> listofPost = branchEntities.getContent();
        // List<Post> listOfPosts = posts.getContent();

        return listofPost.stream().map
                (branchEntity -> mapToDTO(branchEntity)).collect(Collectors.toList());
    }*/

    @Override
    public List<BranchDto> getAllPosts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<BranchEntity> pagedata = branchrepo.findAll(pageable);
        List<BranchEntity> listofpage = pagedata.getContent();
        return  listofpage.stream().map
                (branchentity1 -> mapToDTO(branchentity1)).collect(Collectors.toList());
    }

    @Override
    public BranchDto GetbyId(long ID) {
        BranchEntity branchentity = branchrepo.findById(ID).
                orElseThrow(()-> new ResourceNotFoundException("Data","ID",ID) );
        return mapToDTO(branchentity);

    }

    @Override
    public BranchDto createpost(BranchDto branchdto) {
        // convert DTO to entity
        BranchEntity FinalEntity = maptoEntity(branchdto);
        BranchEntity newPost = branchrepo.save(FinalEntity);

        // convert entity to DTO
        BranchDto  postResponse = mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public BranchDto updateData(BranchDto branchdto, long ID) {
        BranchEntity branchEn = branchrepo.findById(ID).
                orElseThrow(()-> new ResourceNotFoundException("Data","ID",ID) );
        branchEn.setBRANNM(branchdto.getBRANNM());
        branchEn.setADRES1(branchdto.getADRES1());
        branchEn.setROUTNO(branchdto.getROUTNO());
        branchEn.setSWIFTCD(branchdto.getSWIFTCD());
         BranchEntity updatedate = branchrepo.save(branchEn);
        return mapToDTO(updatedate);
    }

    @Override
    public void deleteDate(long ID) {
        BranchEntity branchEn = branchrepo.findById(ID).
                orElseThrow(()-> new ResourceNotFoundException("Data","ID",ID) );

          branchrepo.delete(branchEn);
    }
    /*
    @Override
    public List<BranchDto> GetBranch(int pageNo, int pageSize) {
        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize);
       // Page<Post> posts = postRepository.findAll(pageable);
        Page<BranchEntity> posts = branchrepo.findAll(pageable);
        // get content for page object
       // List<Post> listOfPosts = posts.getContent();

        // get content for page object
          List<BranchEntity> listofPosts = posts.getContent();

        return  listofPosts.stream().map
                (branchentity -> mapToDTO(branchentity)).collect(Collectors.toList());

    }*/

    //Convert Entity into DTO         entity : Source DTO: Destination
    private BranchDto mapToDTO(BranchEntity branchentity){        // Dto -- Entity entity
           BranchDto branchdto = mapper.map(branchentity,BranchDto.class); // DTO dto = entity  DTO
           return  branchdto;
    }

    //Converted DTO to Entity

    private BranchEntity maptoEntity(BranchDto branchdto){
        BranchEntity branchentity = mapper.map(branchdto,BranchEntity.class);
        return  branchentity;
    }



}
