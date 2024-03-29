package android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import com.a.a.a.a.a.a.a;

public class CircleImageView extends ImageView {
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  
  private final RectF c = new RectF();
  
  private final RectF d = new RectF();
  
  private final Matrix e = new Matrix();
  
  private final Paint f = new Paint();
  
  private final Paint g = new Paint();
  
  private final Paint h = new Paint();
  
  private int i = -16777216;
  
  private int j = 0;
  
  private int k = 0;
  
  private Bitmap l;
  
  private BitmapShader m;
  
  private int n;
  
  private int o;
  
  private float p;
  
  private float q;
  
  private ColorFilter r;
  
  private boolean s;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private float w;
  
  public CircleImageView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.j = 0;
    this.i = -16777216;
    this.u = false;
    this.k = 0;
    a();
  }
  
  private Bitmap a(Drawable paramDrawable) {
    if (paramDrawable == null)
      return null; 
    if (paramDrawable instanceof BitmapDrawable)
      return ((BitmapDrawable)paramDrawable).getBitmap(); 
    try {
      Bitmap bitmap;
      if (paramDrawable instanceof android.graphics.drawable.ColorDrawable) {
        bitmap = Bitmap.createBitmap(2, 2, b);
      } else {
        bitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth() - (int)(this.w * 2.0F), paramDrawable.getIntrinsicHeight() - (int)(this.w * 2.0F), b);
      } 
      Canvas canvas = new Canvas(bitmap);
      paramDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
      paramDrawable.draw(canvas);
      return bitmap;
    } catch (Exception paramDrawable) {
      a.a(paramDrawable);
      return null;
    } 
  }
  
  private void a() {
    super.setScaleType(a);
    this.s = true;
    if (this.t) {
      d();
      this.t = false;
    } 
  }
  
  private void b() {
    if (this.f != null)
      this.f.setColorFilter(this.r); 
  }
  
  private void c() {
    Bitmap bitmap;
    if (this.v) {
      bitmap = null;
    } else {
      bitmap = a(getDrawable());
    } 
    this.l = bitmap;
    d();
  }
  
  private void d() {
    if (!this.s) {
      this.t = true;
      return;
    } 
    if (getWidth() == 0 && getHeight() == 0)
      return; 
    if (this.l == null) {
      invalidate();
      return;
    } 
    this.m = new BitmapShader(this.l, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.f.setAntiAlias(true);
    this.f.setShader(this.m);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setColor(this.i);
    this.g.setStrokeWidth(this.j);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setAntiAlias(true);
    this.h.setColor(this.k);
    this.o = this.l.getHeight();
    this.n = this.l.getWidth();
    this.d.set(e());
    this.q = Math.min((this.d.height() - this.j) / 2.0F, (this.d.width() - this.j) / 2.0F);
    this.c.set(this.d);
    if (!this.u && this.j > 0)
      this.c.inset(this.j - 1.0F, this.j - 1.0F); 
    this.p = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
    b();
    f();
    invalidate();
  }
  
  private RectF e() {
    int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i2 = getHeight() - getPaddingTop() - getPaddingBottom();
    int i3 = Math.min(i1, i2);
    float f1 = getPaddingLeft() + (i1 - i3) / 2.0F;
    float f2 = getPaddingTop() + (i2 - i3) / 2.0F;
    float f3 = i3;
    return new RectF(f1, f2, f1 + f3, f3 + f2);
  }
  
  private void f() {
    this.e.set(null);
    float f1 = this.n;
    float f3 = this.c.height();
    float f4 = this.c.width();
    float f5 = this.o;
    float f2 = 0.0F;
    if (f1 * f3 > f4 * f5) {
      f1 = this.c.height() / this.o;
      f2 = (this.c.width() - this.n * f1) * 0.5F;
      f3 = 0.0F;
    } else {
      f1 = this.c.width() / this.n;
      f3 = (this.c.height() - this.o * f1) * 0.5F;
    } 
    this.e.setScale(f1, f1);
    this.e.postTranslate((int)(f2 + 0.5F) + this.c.left, (int)(f3 + 0.5F) + this.c.top);
    this.m.setLocalMatrix(this.e);
  }
  
  public int getBorderColor() { return this.i; }
  
  public int getBorderWidth() { return this.j; }
  
  public ColorFilter getColorFilter() { return this.r; }
  
  @Deprecated
  public int getFillColor() { return this.k; }
  
  public ImageView.ScaleType getScaleType() { return a; }
  
  public boolean isBorderOverlay() { return this.u; }
  
  public boolean isDisableCircularTransformation() { return this.v; }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.v) {
      super.onDraw(paramCanvas);
      return;
    } 
    if (this.l == null)
      return; 
    if (this.k != 0)
      paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.p - this.w, this.h); 
    paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.p - this.w, this.f);
    if (this.j > 0)
      paramCanvas.drawCircle(this.d.centerX(), this.d.centerY(), this.q - this.w, this.g); 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean) {
    if (paramBoolean)
      throw new IllegalArgumentException("adjustViewBounds not supported."); 
  }
  
  public void setBackgroundColor(int paramInt) { setFillColor(paramInt); }
  
  public void setBorderColor(int paramInt) {
    if (paramInt == this.i)
      return; 
    this.i = paramInt;
    this.g.setColor(this.i);
    invalidate();
  }
  
  @Deprecated
  public void setBorderColorResource(int paramInt) { setBorderColor(getContext().getResources().getColor(paramInt)); }
  
  public void setBorderOverlay(boolean paramBoolean) {
    if (paramBoolean == this.u)
      return; 
    this.u = paramBoolean;
    d();
  }
  
  public void setBorderWidth(int paramInt) {
    if (paramInt == this.j)
      return; 
    this.j = paramInt;
    d();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (paramColorFilter == this.r)
      return; 
    this.r = paramColorFilter;
    b();
    invalidate();
  }
  
  public void setDisableCircularTransformation(boolean paramBoolean) {
    if (this.v == paramBoolean)
      return; 
    this.v = paramBoolean;
    c();
  }
  
  public void setElevation2(float paramFloat) {
    this.w = paramFloat;
    this.h.setShadowLayer(paramFloat, 0.0F, paramFloat / 2.0F, -16777216);
    invalidate();
  }
  
  @Deprecated
  public void setFillColor(int paramInt) {
    if (paramInt == this.k)
      return; 
    this.k = paramInt;
    this.h.setColor(paramInt);
    invalidate();
  }
  
  @Deprecated
  public void setFillColorResource(int paramInt) { setFillColor(getContext().getResources().getColor(paramInt)); }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    super.setImageBitmap(paramBitmap);
    c();
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    super.setImageDrawable(paramDrawable);
    c();
  }
  
  public void setImageResource(int paramInt) {
    super.setImageResource(paramInt);
    c();
  }
  
  public void setImageURI(Uri paramUri) {
    super.setImageURI(paramUri);
    c();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType) {
    if (paramScaleType != a)
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType })); 
  }
}


/* Location:              C:\Users\lenovo\Desktop\tool\dex2jar-2.0\classes-dex2jar.jar!\android\widget\CircleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */