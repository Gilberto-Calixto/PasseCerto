package com.dev.PassCerto.repositories;

import com.dev.PassCerto.domain.checkin.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<CheckIn, Integer> {

}
