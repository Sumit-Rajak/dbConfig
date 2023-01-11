package com.margosa.twodbapp.service;

import com.margosa.twodbapp.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service

public class StudentService {
    JdbcTemplate jdbcTemplate1=new JdbcTemplate(datasource());

    JdbcTemplate jdbcTemplate2=new JdbcTemplate(datasources());
    //
    public int save(Student student) {
        try{
            return jdbcTemplate1.update("INSERT INTO student (id ,name,address) VALUES(?,?,?)",
                    new Object[] { student.getId(), student.getName(), student.getAddress() }
            );
        }catch(Exception e){
            throw new RuntimeException("user not saved");
        }
        finally {
            return jdbcTemplate2.update("INSERT INTO student (id ,name,address) VALUES(?,?,?)",
                    new Object[]{student.getId(), student.getName(), student.getAddress()}
            );
        }
    }
  // for mysql config
    @Bean
    public DataSource datasource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setPassword("1234533");// wronge password for mysql
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/crud");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

     // for postgresql config
    @Bean
    public DataSource datasources(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setPassword("123456");
        dataSource.setUsername("postgres");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/crud");
        return dataSource;
    }


}
