package com.dbh.restapi.service;

import com.dbh.restapi.dto.BranchDto;

import java.util.List;

public interface BranchService {

    List<BranchDto>GetBranch();
    List<BranchDto> getAllPosts(int pageNo, int pageSize);
    //List<BranchDto> getAllPosts();
    //List<BranchDto> GetBranch(int pageNo, int pageSize, String sortBy, String sortDir);
    BranchDto  GetbyId(long ID);

    BranchDto createpost(BranchDto branchdto);

    BranchDto updateData (BranchDto branchdto, long ID);

    void  deleteDate(long ID);
}
