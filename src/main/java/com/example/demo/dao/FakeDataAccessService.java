package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person){
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }

    @Override
    public Optional<Person> selectPerson(UUID id){
        return DB.stream()
                .filter(person -> person.getID().equals(id))
                .findFirst();
    }
    @Override
    public int deletePersonById(UUID id){
        Optional<Person> p = selectPerson(id);

        if(p.isEmpty())
            return 0;

        DB.remove(p.get());
        return 1;
    }
    @Override
    public int updatePersonById(UUID id, Person person){
        Optional<Person> p = selectPerson(id);

        if(p.isEmpty())
            return 0;

        DB.set(DB.indexOf(p.get()), person);
        return 1;
    }
}
