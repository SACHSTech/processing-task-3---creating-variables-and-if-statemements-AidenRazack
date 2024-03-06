import processing.core.PApplet;
 /**
  * A program that draws a human face that can adapt to any window size and is generated randomly with a changing background
  * @author: A. Razack
  */
public class Sketch extends PApplet {

  // Define variables
	int x;
  int y;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {

	// put your size call here
    size(400, 400);

  // Random x and y coordinate within the canvas width and height
    x = (int) random(width);
    y = (int) random(height);
  }
  
  /**
  * Called repeatedly, anything drawn to the screen goes here
  */
  public void draw() {
  
    // Change background color based on the position of the face
    if (x < width/2 && y < height/2) {
      background(255, 204, 153);
    } else if (x >= width/2 && y < height/2) {
      background(153, 204, 255); 
    } else if (x < width/2 && y >= height/2) {
      background(255, 153, 204); 
    } else {
      background(153, 255, 204); 
    }

    // Draw head
    fill(255, 204, 153); 
    ellipse(x, y, 200, 200); 

    // Draw eyes
    fill(255); 
    ellipse(x - 30, y - 30, 40, 40); 
    ellipse(x + 30, y - 30, 40, 40); 

    // Draw pupils
    fill(0); 
    ellipse(x - 30, y - 30, 20, 20); 
    ellipse(x + 30, y - 30, 20, 20); 

    // Draw nose
    fill(255, 102, 102);
    triangle(x, y - 10, x - 10, y + 20, x + 10, y + 20); 

    // Draw mouth
    arc(x, y + 40, 100, 80, 0, PI); 

    // Display current time
    fill(0);
    textSize(16);
    text("Current Time: " + hour() + ":" + nf(minute(), 2) + ":" + nf(second(), 2), 20, 20);
  }
}