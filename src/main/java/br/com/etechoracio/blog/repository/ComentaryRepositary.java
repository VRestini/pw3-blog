package br.com.etechoracio.blog.repository;
import br.com.etechoracio.blog.entity.Comentary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentaryRepositary extends JpaRepository<Comentary, Long> {
}
