package ru.gb.jtwo.clesson.online;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList<Person>> map = new HashMap<>();
    String phoneBookName;

    PhoneBook(String name) {
        phoneBookName = name;
    }

    public void add(String surName, int phone, String email) {
        Person addedPerson = new Person(phone, email);
        ArrayList<Person> arrayListVar;
        if (map.containsKey(surName)) {
            arrayListVar = map.get(surName);
            if (arrayListVar.contains(addedPerson)) return;
        } else {
            arrayListVar = new ArrayList<>();
        }
        ;
        arrayListVar.add(addedPerson);
        map.put(surName, arrayListVar);
        System.out.println(map);
    }

    public ArrayList<Integer> getPhoneList(String surName) {
        ArrayList<Person> findedArrayList = map.get(surName);
        ArrayList<Integer> findedArrayListPhone = new ArrayList<>();
        for (Person p : findedArrayList) {
            findedArrayListPhone.add(p.getPhone());
        }
        return findedArrayListPhone;
    }

    public ArrayList<String> getEmailList(String surName) {
        ArrayList<Person> findedArrayList = map.get(surName);
        ArrayList<String> findedArrayListEmail = new ArrayList<>();
        for (Person p : findedArrayList) {
            findedArrayListEmail.add(p.getEmail());
        }
        return findedArrayListEmail;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "map=" + map +
                ", phoneBookName='" + phoneBookName + '\'' +
                '}';
    }
}
