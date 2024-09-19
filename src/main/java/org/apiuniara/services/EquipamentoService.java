package org.apiuniara.services;

import org.apiuniara.models.Equipamento;
import org.apiuniara.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

        @Autowired
        private EquipamentoRepository equipamentoRepository;

        public List<Equipamento> findAll() {
            return equipamentoRepository.findAll();
        }

        public Equipamento save(Equipamento equipamento){
            return  equipamentoRepository.save(equipamento);
        }

        public void reserve(int id){
            Equipamento equipamento = equipamentoRepository.findById(id).get();
            equipamento.setDisponivel(false);
            equipamentoRepository.save(equipamento);
        }

    public void liberar(int id){
        Equipamento equipamento = equipamentoRepository.findById(id).get();
        equipamento.setDisponivel(true);
        equipamentoRepository.save(equipamento);
    }
}
