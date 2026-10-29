package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;

    public ReservationServiceImpl(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable avec l'id : " + id));
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
