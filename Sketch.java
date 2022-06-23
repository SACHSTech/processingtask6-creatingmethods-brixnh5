import processing.core.PApplet;

public class Sketch extends PApplet {
  // Variables for the drawing that can be changed
  int intHouse1X = 125;
  int intHouse1Y = 350;
  int intHouse1Width = 250;
  int intHouse1Height = 250;

  int intHouse1DoorW = 60;
  int intHouse1DoorH = 100;

  int intHouse1RoofHang = 50;
  int intHouse1RoofHeight = 70;

  int intHouse2X = 450;
  int intHouse2Y = 300;
  int intHouse2Width = 250;
  int intHouse2Height = 300;

  int intHouse2DoorW = 60;
  int intHouse2DoorH = 120;

  int intHouse2RoofHang = 40;
  int intHouse2RoofHeight = 90;

  public void settings() {
    // Size of the drawing
      size(800, 800);
    }
  
  public void setup() {
    // Set background cllour
    background(210, 255, 173);
    }
  
  public void draw() {
    // Drawing sky (background)
    drawRect(0, 0, width, height / 2, 137, 207, 240);

    // Drawing clouds 

    // White
    drawCloud(50, 60, 50, 255, 255, 255);

    // Light grey
    drawCloud(200, 60, 50, 220, 220, 220);

    // White
    drawCloud(450, 60, 50, 255, 255, 255);

    // Light grey
    drawCloud(600, 60, 50, 220, 220, 220);
    
    // Drawing the houses
 
    // House 1
    drawRect(intHouse1X, intHouse1Y, intHouse1Width, intHouse1Height, 237, 201, 175);

    // House 2
    drawRect(intHouse2X, intHouse2Y, intHouse2Width, intHouse2Height, 237, 201, 275);
      
    // Drawing the doors
     
    // House 1 door
    drawRect(centerDoor(intHouse1X, intHouse1DoorW, intHouse1Width), alignDoorY(intHouse1Y, intHouse1DoorH, intHouse1Height), intHouse1DoorW, intHouse1DoorH, 66, 40, 14);

    // House 2 door
    drawRect(centerDoor(intHouse2X, intHouse2DoorW, intHouse2Width), alignDoorY(intHouse2Y, intHouse2DoorH, intHouse2Height), intHouse2DoorW, intHouse2DoorH, 100, 100, 100);
    
    // Drawing the roofs 

    // House 1 roof
    drawRoof(intHouse1X, intHouse1Y, intHouse1Width, intHouse1RoofHang, intHouse1RoofHeight, 102, 51, 0);

    // House 2 roof
    drawRoof(intHouse2X, intHouse2Y, intHouse2Width, intHouse2RoofHang, intHouse2RoofHeight, 153, 153, 153);
  }

  /**
   * Method to draw a cloud given a circle
   * @param x Horizontal coordinate
   * @param y Vertical coordinate
   * @param size size of circle (diameter)
   * @param r R colour code
   * @param g G colour code
   * @param b B colour code
   */
  public void drawCloud(float x, float y, float size, int r, int g, int b){
    // Fill colour
    fill(r, g, b);
    noStroke();

    // Determine the distance between each circle 
    float cloudDistance = size / 1.75f;

    // Loop through drawing the 4 bottom circles in the cloud
    for(int i = 0; i < 4; i++){
      ellipse(x + cloudDistance * i, y, size, size);
    }

    //Loop through drawing the top 3 circles in the cloud
    for(int i = 0; i < 3; i++) {
      ellipse(x + cloudDistance * (i + 0.5f), y - cloudDistance, size, size);
    }
    stroke(0);
    }

  /**
   * Method for a rectangle
   * @param x Horizontal coordinate
   * @param y Vertical coordinate
   * @param width Horizontal size
   * @param r R colour code
   * @param g G colour code
   * @param b B colour code
   */
  public void drawRect(float x, float y, float width, float height, int r, int g, int b){
    // Fill colour
    fill(r, g, b);
    noStroke();

    rect(x, y, width, height);
    stroke(0);
  }

  /**
   * Method to draw roof according to a given "house"
   * @param x Horizontal coordinate of house
   * @param y Vertical coordinate of house
   * @param houseWidth Horizontal size of house
   * @param roofHang Distance that the roof should "hang" over the house
   * @param roofHeight Height of the roof
   * @param r R colour code
   * @param g G colour code
   * @param b B colour code
   */
  public void drawRoof(float x, float y, float houseWidth, float roofHang, float roofHeight, int r, int g, int b){
    // Fill Colour
    fill(r, g, b);
    noStroke();

    // Calculations for coordinates of the roof
    float x1 = x - roofHang;
    float y1 = y;
    float x2 = x + houseWidth + roofHang;
    float y2 = y;
    float x3 = x + (houseWidth / 2);
    float y3 = y - roofHeight;
    triangle(x1, y1, x2, y2, x3, y3);
    stroke(0);
  }

  /**
   * Method to get x-coordinates of a centered door in a given house
   * @param x horizontal coordinate of the house in which the door is being centered in
   * @param width horizontal size of door
   * @param height horizontal size of door
   * @return x-coordinate of a centered door in a given house
   */
  public float centerDoor(float x, float widthDoor, float widthHouse){
    float middleOfHouse = widthHouse / 2;
    float doorCentered = middleOfHouse - (widthDoor / 2) + x;
    return doorCentered;
  }

  /**
   * Method to get y-coordinates of a door aligned to the base in a given house
   * @param y vertical coordinate of the house in which the door is being aligned
   * @param heightDoor vertical size of door
   * @param heightHouse vertial size of house
   * @return y-coordinate of a door aligned to the base in a given houes
   */
  public float alignDoorY(float y, float heightDoor, float heightHouse){
    float doorPosY = 0 + y + heightHouse - heightDoor;
    return doorPosY;
  }
}