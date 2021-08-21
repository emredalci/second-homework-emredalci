package dev.patika.gittigidiyorhomework02.controller;


import dev.patika.gittigidiyorhomework02.model.Instructor;
import dev.patika.gittigidiyorhomework02.model.PermanentInstructor;
import dev.patika.gittigidiyorhomework02.model.VisitingResearcher;
import dev.patika.gittigidiyorhomework02.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerTypePredicate;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/saveInstructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }


    /*
    @PostMapping("/savePermanentInstructor")
    public PermanentInstructor savePermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        return (PermanentInstructor) instructorService.save(permanentInstructor);
    }

    @PostMapping("/saveVisitingResearcher")
    public VisitingResearcher saveVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        return (VisitingResearcher) instructorService.save(visitingResearcher);
    }

    */

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }
    @PutMapping("/updateInstructor")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }
    @DeleteMapping("/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Instructor is deleted";
    }

}
