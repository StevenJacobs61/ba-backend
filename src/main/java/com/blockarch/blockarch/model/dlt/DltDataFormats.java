//package com.blockarch.blockarch.model.dlt;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//public class DltDataFormats {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "dlt_solution_id")
//    private DltSolution dlt_solution_id;
//
//    private Boolean json;
//    private Boolean binary;
//    private Boolean solidity;
//    private Boolean rust_smart_contract;
//    private Boolean xml;
//    private Boolean custom_data_format;
//
//    public DltDataFormats() {
//    }
//
//    public DltDataFormats(DltSolution dlt_solution_id,
//                          Boolean json,
//                          Boolean binary,
//                          Boolean solidity,
//                          Boolean rust_smart_contract,
//                          Boolean xml,
//                          Boolean custom_data_format) {
//        this.dlt_solution_id = dlt_solution_id;
//        this.json = json;
//        this.binary = binary;
//        this.solidity = solidity;
//        this.rust_smart_contract = rust_smart_contract;
//        this.xml = xml;
//        this.custom_data_format = custom_data_format;
//    }
//
//    // Other methods if needed
//}
