package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight {
    private Vector _direction;

    /**
     * constructor
     * @param _intensity
     * @param _position
     * @param _kC
     * @param _kL
     * @param _kQ
     * @param _direction
     */
    public SpotLight(Color _intensity, Point3D _position, Vector _direction, double _kC, double _kL, double _kQ) {
        super(_intensity, _position, _kC, _kL, _kQ);
        this._direction = new Vector(_direction).normalized();
    }

    /**
     * @param p
     * @return the intensity at the point p
     */
    @Override
    public Color getIntensity(Point3D p) {
        return (super.getIntensity(p)).scale(Math.max(0, _direction.dotProduct(getL(p))));
    }

    /**
     * @param p
     * @return the direction vector from the light source to the point
     */
    @Override
    public Vector getL(Point3D p) {
        return p.subtract(_position).normalize();
    }
}
