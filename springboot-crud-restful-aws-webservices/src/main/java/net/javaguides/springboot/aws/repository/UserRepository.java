package net.javaguides.springboot.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.aws.entity.User;

// @Repository is optional because JpaRepository extends SimpleJpaRepository and JpaRepositoryImplementation<T, ID> extends JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {  // UserRepository provides crud operations for our User Entity

}
