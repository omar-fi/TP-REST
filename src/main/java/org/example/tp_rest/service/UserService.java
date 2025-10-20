package org.example.tp_rest.service;

import org.example.tp_rest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users;
    public UserService() {
        users = new ArrayList<>();
        User user1 = new User(1,"omar","filali");
        User user2=new User(2,"Moad","khedif");
        User user3=new User(3,"Sana","slax");
        User user4=new User(4,"Ahlam","rouiss");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    public List<User> getUsers() {
        return users;
    }



    public String deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return "User deleted";
            }
        }
        return "User not found";
    }

    public String updateUser(int id,User user){
        int i=0;
        for(User usr:users) {
            if (usr.getId() == id) {
                users.set(i, user);
                return String.format("l'utilisateur %s est bien modifié !", id);
            } else
                i++;
        }
        return String.format("lutilisateur %s n'existe pas !",id);
    }
    public String addUser(User user){
        users.add(user);
        return String.format("lutilisateur %s est bien ajouté !",user.getId());
    }
    public void suppUser(Integer id){
        for(User usr:users)
            if(id==usr.getId()) {
                users.remove(usr);
            }
    }

}

