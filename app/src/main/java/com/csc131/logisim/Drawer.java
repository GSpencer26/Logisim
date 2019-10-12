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
        private static Point size;

        static void set(Point s, ImageView view) {
            size = s;
            gridView = view;
            blockSize = size.x / gridWidth;
            gridHeight = (size.y / blockSize);
            paint = new Paint();
            Grid.initialize(gridWidth, gridHeight, MainActivity.activity);
            blankBitmap = Bitmap.createBitmap(size.x, size.y, Bitmap.Config.ARGB_8888);
            canvas = new Canvas(blankBitmap);
        }

        static void draw() {
            canvas = new Canvas(blankBitmap);
            gridView.setImageBitmap(blankBitmap);
            drawGrid();
        }


        static private void drawGrid() {

            canvas.drawColor(Color.argb(255, 255, 255, 255));

            paint.setColor(Color.argb(255, 0, 0, 0));

            for (int i = 0; i < gridWidth; i++) {
                for (int j = 0; j < gridHeight; j++) {
                    drawCircle((blockSize * i + blockSize / 2), (blockSize * j + blockSize / 2));
                }
            }
        }

        private static void drawCircle(int x, int y) {
            int drawSize = (blockSize / 8);
            canvas.drawCircle(x, y, drawSize, paint);
        }

        static void drawWire(AbstractObject a, AbstractObject b) {
            int ax = a.xposition;
            int ay = a.yposition;
            int bx = b.xposition;
            int by = b.yposition;
            drawWire(ax,ay,bx,by);
        }
        static void drawWire(int ax, int ay, int bx, int by) {
            if (ax > bx && ay > by) {
                int tmp = bx;
                bx = ax;
                ax = tmp;
                tmp = by;
                by = ay;
                ay = tmp;
            }
            paint.setStrokeWidth(10);
            paint.setColor(Color.argb(255, (int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
            int mid = (ax + bx) / 2;
            canvas.drawLine(ax, ay, mid, ay, paint);
            canvas.drawLine(mid, by, bx, by, paint);
            canvas.drawLine(mid, ay, mid, by, paint);
        }

        static int closestBlock(float raw) {
            return (int) (raw / blockSize) * blockSize + blockSize / 2;
        }

        static int blockNum(int x) {
            return (x / blockSize);
        }
    }
