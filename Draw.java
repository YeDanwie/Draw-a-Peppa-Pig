import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Draw extends Application {
	@Override
	public void start(Stage stage) {
		Group group = new Group();
		Scene scene = new Scene(group,400,400);
		scene.setFill(Color.DODGERBLUE);
		
		Pane pane = new Pane();
		pane.getChildren().add(getHead());
		
		Circle nose = new Circle(275,150,25);
		nose.setStroke(Color.web("FF99CC"));
		nose.setStrokeWidth(8);
		nose.setFill(Color.PINK);
		pane.getChildren().add(nose);
		
		Circle hole1 = new Circle(270,150,5);
		hole1.setFill(Color.web("CC66CC"));
		pane.getChildren().add(hole1);
		
		Circle hole2 = new Circle(285,145,5);
		hole2.setFill(Color.web("CC66CC"));
		pane.getChildren().add(hole2);
		
		Circle eye1 = new Circle(180,170,12);
		eye1.setStroke(Color.web("FF99CC"));
		eye1.setStrokeWidth(6);
		eye1.setFill(Color.WHITE);
		pane.getChildren().add(eye1);
		
		Circle eye2 = new Circle(220,150,12);
		eye2.setStroke(Color.web("FF99CC"));
		eye2.setStrokeWidth(6);
		eye2.setFill(Color.WHITE);
		pane.getChildren().add(eye2);
		
		Circle point1 = new Circle(176,170,5);
		point1.setFill(Color.BLACK);
		pane.getChildren().add(point1);
		
		Circle point2 = new Circle(216,150,5);
		point2.setFill(Color.BLACK);
		pane.getChildren().add(point2);
		
		Circle circle = new Circle(140,220,20);
		circle.setFill(Color.web("FF88FF"));
		pane.getChildren().add(circle);
		
		QuadCurve quad = new QuadCurve();
		quad.setStartX(170);
		quad.setStartY(230);
		quad.setEndX(230);
		quad.setEndY(220);
		quad.setControlX(210);
		quad.setControlY(270);
		quad.setFill(null);
		quad.setStroke(Color.web("FF44FF"));
		quad.setStrokeWidth(8);
		quad.setStrokeLineCap(StrokeLineCap.ROUND);
		pane.getChildren().add(quad);

		Text text = new Text("P.P.Z");
		text.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 40));
		text.setX(300);
		text.setY(120);
		text.setFill(Color.PINK);
		text.setStrokeWidth(20);
		pane.getChildren().add(text);
		
		group.getChildren().add(pane);
		
		stage.setScene(scene);
		stage.show();
	}
	
	private Shape getHead() {
		Circle face1 = new Circle(160,200,70);
		
		Ellipse face2 = new Ellipse(230,180,80,40);
		face2.setRotate(25);
		
		Shape face = Path.union(face2, face1);
		
		
		Ellipse ear1 = new Ellipse(180,100,20,15);
		ear1.setRotate(65);
		Ellipse ear2 = new Ellipse(225,100,20,15);
		ear2.setRotate(85);
		Shape ears = Path.union(ear1, ear2);
		ears.setTranslateY(12);
		ears.setTranslateX(-20);
		
		
		Shape head = Path.union(face, ears);
		head.setStroke(Color.web("FF99CC"));
		head.setStrokeWidth(8);
		head.setFill(Color.PINK);
		head.setRotate(-35);
		return head;
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
