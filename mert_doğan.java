/*
 * Author : Mert Doðan
 * Date : 26.11.2017
 * Program reads students' names and grades from a text file and plot the name and grades in rectangles. Rectangle size is 100 and students grades sum's size must be max 100. 
 */

package mert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class mert_doðan extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Group root = new Group();
        Scene scene = new Scene(root, 900, 800, Color.WHITE);
        System.out.println("Enter a file name to control");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		Student[] students=generateStudentArray( fileName );		
		Label [] labels=new Label[students.length];
                Rectangle [] recs =new Rectangle [students.length];
                for(int i=0 ; i< students.length ; i++){
                    labels[i]=new Label(students[i].getName());
                    labels[i].setLayoutX(100);
                    labels[i].setLayoutY(100+(i*30));
                    root.getChildren().add(labels[i]);
                    recs[i]=new Rectangle(150, 100+(i*30) , 540 , 25);
                    recs[i].setFill(Color.DODGERBLUE);
                    root.getChildren().add(recs[i]);
                    
                    Rectangle [] gradesRec =new Rectangle [3];
                    gradesRec[0]=new Rectangle(160, 103+(i*30)  , students[i].grades[0]*5 , 19);
                    gradesRec[0].setFill(Color.WHITE);
                    root.getChildren().add(gradesRec[0]);
                    
                    gradesRec[1]=new Rectangle(160+10 +students[i].grades[0]*5 , 103+(i*30)   , students[i].grades[1]*5 , 19);
                    gradesRec[1].setFill(Color.WHITE);
                    root.getChildren().add(gradesRec[1]);
                    
                    gradesRec[2]=new Rectangle(160+10+10+students[i].grades[0]*5+students[i].grades[1]*5, 103+(i*30)   , students[i].grades[2]*5  , 19);
                    gradesRec[2].setFill(Color.WHITE);
                    root.getChildren().add(gradesRec[2]);
                    
                    Label [] gradeLabel =new Label [3];
                    gradeLabel[0]=new Label( Integer.toString( students[i].grades[0]) );
                    gradeLabel[0].setLayoutX(163);
                    gradeLabel[0].setLayoutY(102+(i*30));
                    root.getChildren().add(gradeLabel[0]);
                    
                    gradeLabel[1]=new Label( Integer.toString( students[i].grades[1]) );
                    gradeLabel[1].setLayoutX(160+10 +students[i].grades[0]*5);
                    gradeLabel[1].setLayoutY(102+(i*30));
                    root.getChildren().add(gradeLabel[1]);
                    
                    gradeLabel[2]=new Label( Integer.toString( students[i].grades[2]) );
                    gradeLabel[2].setLayoutX(160+10+10+students[i].grades[0]*5+students[i].grades[1]*5);
                    gradeLabel[2].setLayoutY(102+(i*30));
                    root.getChildren().add(gradeLabel[2]);
                }
        
             
        primaryStage.setTitle("Graph of students grades");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
    private static Student[] generateStudentArray(String fileName) throws FileNotFoundException {
		File file = new java.io.File(fileName);
		Scanner input = new Scanner ( file );				
		//count how many students in the file
		int counter=0;
		Student[] students;
		while (input.hasNextLine()) {
			input.nextLine();
			counter++;
		}
		input.close();
		students =new Student[counter];
		//parsing part
		input = new Scanner ( file );
		int j=0;
		while (input.hasNextLine()) {
			String name =input.next().trim();
			String [] grades=input.nextLine().trim().split(" ");	
			int [] gradess =new int [3];
			for(int i=0 ; i<3 ; i++ ) {				
				gradess[i]=Integer.parseInt(grades[i]);						
			}
			students[j]=new Student(name,gradess);
			j++;
		}
		input.close();
		//parsing is over	
		return students;
	}

    
}