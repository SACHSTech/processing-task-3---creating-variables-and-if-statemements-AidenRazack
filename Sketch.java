import processing.core.PApplet;
 /**
  * A program that draws a human face that can adapt to any window size and is generated randomly with a changing background
  * @author: A. Razack
  */
public class Sketch extends PApplet {

  // Define variables
	int intRandomXVal;
  int intRandomYVal;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {

	// put your size call here
    size(400, 400);

    // Set random x and y coordinate within the canvas width and height
    intRandomXVal = (int) random(width);
    intRandomYVal = (int) random(height);
  }
  
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
  
    // Change background color based on the position of the face
    if (intRandomXVal < width/2 && intRandomYVal < height/2) {
      background(255, 204, 153);
    } else if (intRandomXVal >= width/2 && intRandomYVal < height/2) {
      background(153, 204, 255); 
    } else if (intRandomXVal < width/2 && intRandomYVal >= height/2) {
      background(255, 153, 204); 
    } else {
      background(153, 255, 204); 
    }

    // Draw head
    fill(255, 204, 153); 
    ellipse(intRandomXVal, intRandomYVal, 200, 200); 

    // Change eye color if it's on the left side, but not if it's on the right side
    if (intRandomXVal < width / 2 || !(intRandomXVal >= width / 2 || intRandomYVal < height / 2)) {
      fill(255); 
    } else {
      fill(153); 
    }

    // Draw eyes
    ellipse(intRandomXVal - 30, intRandomYVal - 30, 40, 40); 
    ellipse(intRandomXVal + 30, intRandomYVal - 30, 40, 40); 

    // Draw pupils
    fill(0); 
    ellipse(intRandomXVal - 30, intRandomYVal - 30, 20, 20); 
    ellipse(intRandomXVal + 30, intRandomYVal - 30, 20, 20); 

    // Draw nose
    fill(255, 102, 102);
    triangle(intRandomXVal, intRandomYVal - 10, intRandomXVal - 10, intRandomYVal + 20, intRandomXVal + 10, intRandomYVal + 20); 

    // Draw mouth
    arc(intRandomXVal, intRandomYVal + 40, 100, 80, 0, PI); 

    // Display current time
    fill(0);
    textSize(16);
    text("Current Time: " + hour() + ":" + nf(minute(), 2) + ":" + nf(second(), 2), 20, 20);
  }
}