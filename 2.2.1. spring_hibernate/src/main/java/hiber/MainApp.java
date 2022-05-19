package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

     // userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      //userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User user1 = new User("Ivan","Ivanov", "@ivan");
      User user2 = new User("David","Petrov", "@ivan");
      User user3 = new User("Dima","Sidorov", "@ivan");
      User user4 = new User("Vova","Korova", "@ivan");
      Car car = new Car("Nissan",350);
      Car car1 = new Car("BMW",585);
      Car car2 = new Car("Lexus",200);
      Car car3 = new Car("Audi",6);
      user1.setCar(car);
      user2.setCar(car1);
      user3.setCar(car2);
      user4.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar().toString());
      }
      List<User> users1 = userService.getUserCar("Nissan", 350);
      for (User user : users1) {
         System.out.println("Id user for car = " + user.getId());

         context.close();
      }
   }
}