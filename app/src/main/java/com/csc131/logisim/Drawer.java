    package com.csc131.logisim;

    import android.graphics.Bitmap;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.Point;
    import android.widget.ImageView;

    class Drawer {
        static private int cellSize;
        static private int gridWidth = 5;   //Predetermined width of grid
        static private int gridHeight;
        static private Bitmap blankBitmap;
        static private Canvas canvas;
        static private Paint paint;
        static private ImageView gridView;

        //
        static void set(Point size, ImageView view) {
            gridView = view;
            cellSize = size.x / gridWidth;     //Size of individual grid cells
            gridHeight = (size.y / cellSize);  //Height determined by the dimension of the screen
            paint = new Paint();
            blankBitmap = Bitmap.createBitmap(size.x, size.y, Bitmap.Config.ARGB_8888);
        }

        //Draws grid and all wires
        static void draw() {
            canvas = new Canvas(blankBitmap);
            gridView.setImageBitmap(blankBitmap);
            drawGrid();
            drawAllWires();
        }


        static private void drawGrid() {
            canvas.drawColor(Color.argb(255, 255, 255, 255));
            paint.setColor(Color.argb(255, 0, 0, 0));
            for (int i = 0; i < gridWidth; i++) {
                for (int j = 0; j < gridHeight; j++) {
                    drawCircle((cellSize * i + cellSize / 2), (cellSize * j + cellSize / 2));
                }
            }
        }

        //Draw circles at each cell
        private static void drawCircle(int x, int y) {
            int drawSize = (cellSize / 8);
            canvas.drawCircle(x, y, drawSize, paint);
        }

        //Alternate way to draw wires
        static void drawWire(AbstractObject a, AbstractObject b) {
            int ax = a.xposition;
            int ay = a.yposition;
            int bx = b.xposition;
            int by = b.yposition;
            drawWire(ax,ay,bx,by);
        }

        //Draw wires from
        static void drawWire(int x0, int y0, int x1, int y1) {

            //Set the wire to have a consistent orientation
            if (x0 > x1 && y0 > y1) {
                int tmp = x1;
                x1 = x0;
                x0 = tmp;
                tmp = y1;
                y1 = y0;
                y0 = tmp;
            }
            paint.setStrokeWidth(10);

            //Set a random colorful wire to differentiate between other wires
            paint.setColor(Color.argb(255, (int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
            int mid = (x0 + x1) / 2;
            canvas.drawLine(x0, y0, mid, y0, paint);
            canvas.drawLine(mid, y1, x1, y1, paint);
            canvas.drawLine(mid, y0, mid, y1, paint);
        }

        //return location of cellCenter closest to input
        static int cellCenter(float input) {
            return (int)(input / cellSize) * cellSize + cellSize / 2;
        }

        //Draw all wires from all gates to their inputs
        static void drawAllWires(){
            for(int i=0; i<Grid.gates.size(); i++){
                for(int j=0; j<Grid.gates.get(i).inputs.size(); j++){
                    Drawer.drawWire(Grid.gates.get(i),Grid.gates.get(i).inputs.get(j));
                }
            }
        }
    }
