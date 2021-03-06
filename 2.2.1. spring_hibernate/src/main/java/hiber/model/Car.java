package hiber.model;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int series;
    // @OneToOne
    // @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL) //optional = false,
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';

    }
}