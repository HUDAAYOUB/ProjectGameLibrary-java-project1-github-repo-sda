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
    private String title;
    private int releaseYear;
    private String genre;
    private String platform;
    private String description;
    @Column(name = "image_url")
    private String imageUrl;

    @DecimalMax(value = "5.0", message = "The rating cannot be higher than 5.0")
    @DecimalMin(value = "0.0", message = "The rating cannot be lower than 0.0")
    private double rating;
    private String Developers;
    private String Mode;
    private String Designer;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-dd-mm")
    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    public GamesLibrary(Long id, String title, int releaseYear, String genre, String platform, String description, String imageUrl, double rating, String developers, String mode, String designer, LocalDateTime dateAdded) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.platform = platform;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
        Developers = developers;
        Mode = mode;
        Designer = designer;
        this.dateAdded = dateAdded;
    }

    public GamesLibrary() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setStatus(GameStatus status) {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

