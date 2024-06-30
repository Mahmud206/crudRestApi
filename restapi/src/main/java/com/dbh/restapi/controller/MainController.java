package com.dbh.restapi.controller;

import com.dbh.restapi.dto.BranchDto;
import com.dbh.restapi.service.BranchService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/dbh")
public class MainController {


   private BranchService brnserv;

    public MainController(BranchService brnserv) {
        this.brnserv = brnserv;
    }


    /*@GetMapping("/get")
    public List<BranchDto> GetAllBranch(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value ="sortBy",defaultValue = "BRANCD",required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = "asc",required = false) String sortDir
    ){
        return brnserv.GetBranch(pageNo,pageSize,sortBy,sortDir);
    }*/

     @GetMapping("/get")
     public List<BranchDto> GetAllBranch(){
     return brnserv.GetBranch();
     }

    @GetMapping("/get1")
    public List<BranchDto> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "4", required = false) int pageSize
    )
    {

        return brnserv.getAllPosts(pageNo, pageSize);
    }

     @GetMapping("id/{ID}")
    public ResponseEntity<BranchDto> getdatabyid(@PathVariable(name = "ID") long ID){
        return ResponseEntity.ok(brnserv.GetbyId(ID));
     }
     @PostMapping("/post")
     public ResponseEntity<BranchDto> postData(@Valid  @RequestBody BranchDto branchdto){
        return new ResponseEntity<>(brnserv.createpost(branchdto), HttpStatus.CREATED);
     }

     @PutMapping("update/{ID}")
     public ResponseEntity<BranchDto> updateData(@Valid @RequestBody BranchDto branchdto,@PathVariable(name="ID") long ID){
         BranchDto postResponse = brnserv.updateData(branchdto,ID);
         return new ResponseEntity <>(postResponse,HttpStatus.OK);
     }

     @DeleteMapping("del/{ID}")
     public ResponseEntity<String> deleteDate(@PathVariable(name="ID") long ID){
         brnserv.deleteDate(ID);

         return  new ResponseEntity<>("Successfully Deleted Data ",HttpStatus.OK);
     }

    /*
     @PostMapping("/post")
     public ResponseEntity<branchEntityDto>postData(@RequestBody branchEntityDto branchEntityDto){
        return new ResponseEntity<>(brnsrv.createPost(branchEntityDto),HttpStatus.OK);
     }
     @GetMapping("id/{brancd}")
    public ResponseEntity<branchEntityDto> getdataby(@PathVariable(name="brancd") long brancd) {
        return ResponseEntity.ok(brnsrv.getdatabyID(brancd));
    }
*/
    /*@GetMapping("/get")
    public List<BranchDto> GetAllBranch(
            @RequestParam(value = "pageNo",defaultValue ="0",required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue ="5",required = false ) int pageSize
    ){
        return brnserv.GetBranch(pageNo,pageSize);
    }*/
}

