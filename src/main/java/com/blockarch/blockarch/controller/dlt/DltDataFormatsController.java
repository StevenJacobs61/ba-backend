//package com.blockarch.blockarch.controller.dlt;
//
//import com.blockarch.blockarch.repository.dlt.DltDataFormatsRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/dlt-data-formats") // Adjust the mapping to your preference
//public class DltDataFormatsController {
//
//    private final DltDataFormatsRepository dltDataFormatsRepository;
//
//    public DltDataFormatsController(DltDataFormatsRepository dltDataFormatsRepository) {
//        this.dltDataFormatsRepository = dltDataFormatsRepository;
//    }
//
//    @GetMapping
//    public ResponseEntity getAllDltDataFormats() {
//        return ResponseEntity.ok(this.dltDataFormatsRepository.findAll());
//    }
//
//    // Add more endpoints for specific operations (create, update, delete, etc.) as needed
//}
