package ec.jorgetorres.shrimpfarmweb.service;

import ec.jorgetorres.shrimpfarmweb.domain.ShrimpFarm;
import ec.jorgetorres.shrimpfarmweb.repository.ShrimpFarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShrimpFarmService {
  private ShrimpFarmRepository shrimpFarmRepository;

  @Autowired
  public ShrimpFarmService(ShrimpFarmRepository shrimpFarmRepository) {
    super();
    this.shrimpFarmRepository = shrimpFarmRepository;
  }

  public List<ShrimpFarm> list() {
    return shrimpFarmRepository.findAllByOrderByNameAsc();
  }
}