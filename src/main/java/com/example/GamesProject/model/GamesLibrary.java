package com.example.GamesProject.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import java.time.LocalDateTime;

//*********** Table For Games *********
@Entity
public class GamesLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // ********** Relation
    private String title;
    private String platform;
    private String genre;
    private Integer releaseYear;
    @DecimalMax(value = "5.0", message = "The rating cannot be higher than 5.0")
    @DecimalMin(value = "0.0", message = "The rating cannot be lower than 0.0")
    private double rating;
    private String Developers;
    private String Mode;
    private String Designer;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-dd-mm")
    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    public GamesLibrary() {
    }

    public GamesLibrary(Long id, User user, String title, String platform, String genre, Integer releaseYear,  double rating, String developers, String mode, String designer, LocalDateTime dateAdded) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.platform = platform;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        Developers = developers;
        Mode = mode;
        Designer = designer;
        this.dateAdded = dateAdded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getDevelopers() {
        return Developers;
    }

    public void setDevelopers(String developers) {
        Developers = developers;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    public String getDesigner() {
        return Designer;
    }

    public void setDesigner(String designer) {
        Designer = designer;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}