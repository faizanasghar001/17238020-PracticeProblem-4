
import javafx.application.Application;

import  javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import java.time.Year;

public class Main extends Application{
    private Label titleLbl, firstNameLbl, lastNameLbl, yearLbl, monthLbl, dayLbl, outputLbl;
    private TextField firstNameTxt, lastNameTxt, yearTxt, monthTxt, dayTxt;
    private Button heartRateBtn;
    private VBox root, yearVbox, monthVbox, dayVbox;
    private HBox dateHbox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        titleLbl = new Label("Heart rate calculator");
        firstNameLbl = new Label("First Name");
        lastNameLbl = new Label("Last Name");
        yearLbl = new Label("Year");
        monthLbl = new Label("Month");
        dayLbl = new Label("Day");
        outputLbl = new Label();
        outputLbl.setStyle("-fx-font:24px Arial; -fx-text-fill:red;");
        firstNameTxt = new TextField();
        lastNameTxt = new TextField();
        yearTxt = new TextField();
        monthTxt = new TextField();
        dayTxt = new TextField();
        heartRateBtn = new Button("Calculate heart rate ");
        yearVbox = new VBox();
        yearVbox.getChildren().addAll(yearLbl,yearTxt);
        monthVbox = new VBox();
        monthVbox.getChildren().addAll(monthLbl,monthTxt);
        dayVbox = new VBox();
        dayVbox.getChildren().addAll(dayLbl,dayTxt);
        dateHbox = new HBox();
        dateHbox.getChildren().addAll(yearVbox,monthVbox,dayVbox);
        dateHbox.setSpacing(20);
        root = new VBox();
        root.getChildren().addAll(titleLbl,firstNameLbl,firstNameTxt,lastNameLbl,lastNameTxt,dateHbox,heartRateBtn,outputLbl);
        heartRateBtn.setOnAction(e->  {
            int year = Integer.parseInt(yearTxt.getText());
            String monthText = monthTxt.getText();
            int day = Integer.parseInt(dayTxt.getText());
            String fullName = firstNameTxt.getText()+ " " +lastNameTxt.getText();
            Month month = getMonth(monthText);
            int ageInYears = getAgeInYears(year,month,day);
            double maximumHeartRate = getHeartRate(ageInYears);
            String targetHeartRate = getTargetHeartRate(maximumHeartRate);
            String result;
            result = "Name: "+fullName+"\n"
                     +"Age: "+ageInYears+"\n"
                     +"Maximum Heart Rate: "+maximumHeartRate+"\n"
                    +"Target Heart Rate: " +targetHeartRate;
            outputLbl.setText(result);
        });
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Heart rate calculator");
        primaryStage.show();
    }
    private int getAgeInYears(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }

    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("april")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("may")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("june")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("NOVEMBER")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("DECEMBER")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;
    }
    private double getHeartRate(int year){
        return 220 - year;
    }
    private String getTargetHeartRate(double heartRate){
        return (int)(heartRate * 0.5) + " - "+(int)(heartRate * 0.85);
    }
    public static void main(String[] args){
        launch(args);
    }
}
