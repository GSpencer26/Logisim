    package com.csc131.logisim;

    import android.graphics.Bitmap;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.Point;
    import android.widget.ImageView;

    class Grid {
        static private int blockSize;
        private int gridWidth = 5;
        private int gridHeight;
        private Bitmap blankBitmap;
        private Canvas canvas;
        Paint paint;
        private ImageView gridView;

        Grid(Point size, ImageView view) {
            gridView = view;
            blockSize = size.x / gridWidth;
            gridHeight = (int)(size.y / blockSize);
            paint = new Paint();
            blankBitmap = Bitmap.createBitmap(size.x, size.y, Bitmap.Config.ARGB_8888);
            canvas = new Canvas(blankBitmap);
            draw();
        }

        void draw() {

            drawGrid();
        }


        private void drawGrid(){
            gridView.setImageBitmap(blankBitmap);

            canvas.drawColor(Color.argb(255, 255, 255, 255));

            paint.setColor(Color.argb(255, 0, 0, 0));

            for (int i=0; i< gridWidth; i++){
                for(int j=0; j< gridHeight; j++){
                    drawCircle((int)(blockSize * i + blockSize/2), (int)(blockSize * j + blockSize/2));
                }
            }
        }

        void drawCircle(int x, int y) {
            int drawSize = (int)(blockSize/8);
            canvas.drawCircle(x,y, drawSize, paint);
        }

        static float getPos(float raw){
            return (int)(raw/blockSize)*blockSize+blockSize/2;
        }
    }
