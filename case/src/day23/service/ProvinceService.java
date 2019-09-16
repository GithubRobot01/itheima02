package day23.service;

import day23.domain.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    String findAllJson();
}
