/*******************************************************************************
 * Copyright (c) 2010 Nicolas Roduit.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Roduit - initial API and implementation
 ******************************************************************************/
package org.weasis.core.ui.model.graphic.imp;

import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Objects;
import java.util.Optional;

import javax.xml.bind.annotation.XmlRootElement;

import org.weasis.core.ui.model.graphic.AbstractGraphic;
import org.weasis.core.ui.model.graphic.Graphic;
import org.weasis.core.ui.model.utils.exceptions.InvalidShapeException;
import org.weasis.core.ui.util.MouseEventDouble;

/**
 * @author Nicolas Roduit
 */
@XmlRootElement(name = "nonEditable")
public class NonEditableGraphic extends AbstractGraphic {
    private static final long serialVersionUID = -6063521725986473663L;
    private Stroke stroke;

    public NonEditableGraphic(Shape path) {
        this(path, null);
    }

    public NonEditableGraphic(Shape path, Stroke stroke) {
        super(0);
        this.stroke = stroke;
        setShape(path, null);
        updateLabel(null, null);
    }

    public NonEditableGraphic(NonEditableGraphic graphic) {
        super(graphic);
    }

    @Override
    protected void initCopy(Graphic graphic) {
        super.initCopy(graphic);
        if (graphic instanceof NonEditableGraphic) {
            this.stroke = ((NonEditableGraphic) graphic).stroke;
        }
    }

    @Override
    public NonEditableGraphic copy() {
        return new NonEditableGraphic(this);
    }

    @Override
    public void setFilled(Boolean filled) {
        if (!Objects.equals(this.filled, filled)) {
            this.filled = Optional.ofNullable(filled).orElse(DEFAULT_FILLED);
            fireDrawingChanged();
        }
    }

    @Override
    protected void prepareShape() throws InvalidShapeException {
        if (!isShapeValid()) {
            throw new InvalidShapeException("This shape cannot be drawn"); //$NON-NLS-1$
        }
        buildShape();
    }

    @Override
    public void buildShape() {
        updateLabel(null, null);
    }

    @Override
    public String getUIName() {
        return "";
    }

    @Override
    public boolean isOnGraphicLabel(MouseEventDouble mouseevent) {
        return false;
    }

    @Override
    public String getDescription() {
        return ""; //$NON-NLS-1$
    }

    @Override
    public Area getArea(AffineTransform transform) {
        return new Area();
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
    
    @Override
    public Stroke getStroke(Float lineThickness) {
        if(stroke != null){
            return stroke;
        }
        return super.getDashStroke(lineThickness);
    }
}
