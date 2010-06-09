/*
 * Copyright (c) 2010 Brookhaven National Laboratory
 * Copyright (c) 2010 Helmholtz-Zentrum Berlin für Materialien und Energie GmbH
 * Subject to license terms and conditions.
 */

package gov.bnl.channelfinder;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author Ralph Lange <Ralph.Lange@bessy.de>
 */

@XmlRootElement(name = "channel")
public class XmlChannel {
    private String name = null;
    private String owner = null;
    private Collection<XmlProperty> properties = new ArrayList<XmlProperty>();
    private Collection<XmlTag> tags = new ArrayList<XmlTag>();
  
    /** Creates a new instance of XmlChannel */
    public XmlChannel() {
    }

    /**
     * Creates a new instance of XmlChannel.
     *
     * @param name channel name
     * @param owner owner name
     */
    public XmlChannel(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    /**
     * Getter for channel name.
     *
     * @return name
     */
    @XmlAttribute
    public String getName() {
        return name;
    }

    /**
     * Setter for channel name.
     *
     * @param name the value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for channel owner.
     *
     * @return owner
     */
    @XmlAttribute
    public String getOwner() {
        return owner;
    }

    /**
     * Setter for channel owner.
     *
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Getter for channel's XmlProperties.
     *
     * @return XmlProperties
     */
    @XmlElement(name = "property")
    @XmlElementWrapper(name = "properties")
    public Collection<XmlProperty> getXmlProperties() {
        return properties;
    }

    /**
     * Setter for channel's XmlProperties.
     *
     * @param properties XmlProperty collection
     */
    public void setXmlProperties(Collection<XmlProperty> properties) {
        this.properties = properties;
    }

    /**
     * Adds an XmlProperty to the collection.
     *
     * @param property single XmlProperty
     */
    public void addProperty(XmlProperty property) {
        this.properties.add(property);
    }

    /**
     * Getter for the channel's XmlTags.
     *
     * @return the XmlTags for this channel
     */
    @XmlElement(name = "tag")
    @XmlElementWrapper(name = "tags")
    public Collection<XmlTag> getXmlTags() {
        return tags;
    }

    /**
     * Setter for the channel's XmlTags.
     *
     * @param tags XmlTag collection
     */
    public void setXmlTags(Collection<XmlTag> tags) {
        this.tags = tags;
    }

    /**
     * Adds an XmlTag to the collection.
     *
     * @param tag
     */
    public void addTag(XmlTag tag) {
        this.tags.add(tag);
    }

    /**
     * Creates a compact string representation for the log.
     *
     * @param data XmlChannel to create the string representation for
     * @return string representation
     */
    public static String toLog(XmlChannel data) {
        StringBuilder s = new StringBuilder();
        s.append(data.getName() + "(" + data.getOwner() + "):[");
        for (XmlProperty p : data.getXmlProperties()) {
            s.append(XmlProperty.toLog(p) + ",");
        }
        for (XmlTag t : data.getXmlTags()) {
            s.append(XmlTag.toLog(t) + ",");
        }
        if (data.getXmlProperties().size() > 0 || data.getXmlTags().size() > 0) {
            s.delete(s.length()-1, s.length());
        }
        s.append("]");
        return s.toString();
    }
}
