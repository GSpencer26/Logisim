    package com.csc131.logisim;

    import android.graphics.Bitmap;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.Point;
    import android.widget.ImageView;

    class Drawer {
        static private int blockSize;
        static private int gridWidth = 5;
        static private int gridHeight;
        static private Bitmap blankBitmap;
        static private Canvas canvas;
        static private Paint paint;
        static private ImageView gridView;

        static void set(Point size, ImageView view) {
            gridView = view;
            blockSize = size.x / gridWidth;
            gridHeight = (int)(size.y / blockSize);
            paint = new Paint();
            blankBitmap = Bitmap.createBitmap(size.x, size.y, Bitmap.Config.ARGB_8888);
            canvas = new Canvas(blankBitmap);
            Grid.initalize(gridWidth, gridHeight, MainActivity.activity);
        }

        static void draw(){
            drawGrid();
        }



        static private void drawGrid(){
            gridView.setImageBitmap(blankBitmap);

            canvas.drawColor(Color.argb(255, 255, 255, 255));

            paint.setColor(Color.argb(255, 0, 0, 0));

            for (int i=0; i< gridWidth; i++){
                for(int j=0; j< gridHeight; j++){
                    drawCircle((int)(blockSize * i + blockSize/2), (int)(blockSize * j + blockSize/2));
                }
            }
        }

        static void drawCircle(int x, int y) {
            int drawSize = (int)(blockSize/8);
            canvas.drawCircle(x,y, drawSize, paint);
        }

        static void drawWire(int x0, int y0, int x1, int y1){
            if (x0>x1 && y0>y1){
                int tmp = x1;
                x1 = x0;
                x0 = tmp;
                tmp = y1;
                y1 = y0;
                y0 = tmp;
            }
            paint.setStrokeWidth(10);
            paint.setColor(Color.argb(255, 15, 15, 15));
            int mid = (x0+x1)/2;
            canvas.drawLine(x0,y0,mid,y0,paint);
            canvas.drawLine(mid,y1,x1,y1,paint);
            canvas.drawLine(mid,y0,mid,y1,paint);
        }

        static int closestBlock(float raw){
            return (int)(raw/blockSize)*blockSize+blockSize/2;
        }
        static int blockNum(int x){
            return (x/blockSize);
        }
    }