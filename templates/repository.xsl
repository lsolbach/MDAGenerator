<?xml version="1.0" encoding="utf-8"?>
<!--
	Generator for XMI registry builder
	Ludger Solbach
	-->
<xsl:stylesheet version ="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema">
	<xsl:output method="text"/>
	<xsl:template match="xs:schema">
package org.soulspace.xmi.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import org.soulspace.xmi.base.XmiObject;
import org.soulspace.xmi.base.XmiRepositoryException;
import org.soulspace.xmi.marshal.XMI;
import org.soulspace.xmi.marshal.XMI_content;
import org.soulspace.xmi.marshal.XMI_contentItem;
<!-- xsl:apply-templates mode="imports"/ -->

/**
 * XMIRepository
 * Generated from schema
 */
public class XMIRepository {
		
	private File file;
	private File[] files;
	private Map&lt;String, XmiObject&gt; xmiIdMap = new HashMap&lt;String, XmiObject&gt;();
	private Map&lt;String, XmiObject&gt; nameMap = new HashMap&lt;String, XmiObject&gt;();
	<xsl:apply-templates mode="collections"/>
	private boolean profile = false;
	
	/**
	 * Constructor
	 */
	public XMIRepository() {
		super();
	}

	public XMIRepository(String filename) {
		super();
		// this.file = new File(filename);
		files = new File[] { new File(filename) };
	}

	public XMIRepository(File file) {
		super();
		files = new File[] { file };
	}

	public XMIRepository(String[] filenames) {
		super();
		files = new File[filenames.length];
		for (int i = 0; i &lt; filenames.length; i++) {
			files[i] = new File(filenames[i]);
		}
	}

	public XMIRepository(File[] files) {
		super();
		this.files = files;
	}

	public void initRepository() {
		for (File file : files) {
			XMI xmi = readXmi(file);
			buildXmiRepository(xmi);
		}
	}

	public void initRepository(File file) {
		XMI xmi = readXmi(file);
		buildXmiRepository(xmi);
	}

	public void loadModel(File modelFile) {
		profile = false;
		XMI xmi = readXmi(modelFile);
		buildXmiRepository(xmi);
	}

	public void loadProfile(File profileFile) {
		profile = true;
		XMI xmi = readXmi(profileFile);
		buildXmiRepository(xmi);
	}

	public XMI readXmi(File file) {
		XMI xmi = null;
		FileReader reader;

		try {
			reader = new FileReader(file);
			xmi = (XMI) XMI.unmarshal(reader);
		} catch (Exception e) {
			throw new XmiRepositoryException("Error reading xmi file!", e);
		}

		return xmi;
	}

	public void buildXmiRepository(XMI xmi) {
		if (xmi != null) {
			XMIBuilder builder;
			if(profile) {
				builder = new XMIBuilder(this, true);
			} else {
				builder = new XMIBuilder(this);
			}
			XMI_content content = xmi.getXMI_content();
			Enumeration e = content.enumerateXMI_contentItem();
			while (e.hasMoreElements()) {
				XMI_contentItem cI = (XMI_contentItem) e.nextElement();
				if (cI.getModel() != null) {
					builder.traverseModel("", cI.getModel());
				} else {
					System.err.println("unknown xmi content!");
				}
			}
		}
	}
	<xsl:apply-templates mode="registry"/>
	<xsl:apply-templates mode="access"/>	
	public Map getXmiIdMap() {
		return xmiIdMap;
	}

	public Map getNameMap() {
		return nameMap;
	}
	
	public XmiObject lookupByXmiId(String xmiId) {
		return (XmiObject) xmiIdMap.get(xmiId);
	}

	public XmiObject lookupByQualifiedName(String qualifiedName) {
		return (XmiObject) nameMap.get(qualifiedName);
	}
}
	</xsl:template>

	<xsl:template
		match="xs:element[@name and not(starts-with(@name, 'XMI'))]/xs:complexType/xs:attribute[@ref='xmi.id']"
		mode="imports">
import org.soulspace.xmi.marshal.<xsl:value-of select="translate(../../@name, '.', '_')"/>;
	</xsl:template>

	<xsl:template
		match="xs:element[@name and not(starts-with(@name, 'XMI'))]/xs:complexType/xs:attribute[@ref='xmi.id']"
		mode="collections">
	private List&lt;org.soulspace.xmi.marshal.<xsl:value-of select="translate(../../@name, '.', '_')"/>&gt; xmi<xsl:value-of select="translate(../../@name, '.', '_')"/>List = new ArrayList&lt;org.soulspace.xmi.marshal.<xsl:value-of select="translate(../../@name, '.', '_')"/>&gt;();
	</xsl:template>

	<xsl:template
		match="xs:element[@name and not(starts-with(@name, 'XMI'))]/xs:complexType/xs:attribute[@ref='xmi.id']"
		mode="registry">
	void register<xsl:value-of select="translate(../../@name, '.', '_')"/>(
	               String xmiId, org.soulspace.xmi.marshal.<xsl:value-of select="translate(../../@name, '.', '_')"/> element) {
		xmi<xsl:value-of select="translate(../../@name, '.', '_')"/>List.add(element);
		xmiIdMap.put(element.getXmi_id(), element);
		<xsl:if test="../../@name='Package'
									or ../../@name='Class'
									or ../../@name='Interface'
									or ../../@name='Operation'
									or ../../@name='Attribute'
									or ../../@name='Method'
									or ../../@name='TagDefinition'
									or ../../@name='Stereotype'
									or ../../@name='Association'
									or ../../@name='AssociationClass'
									or ../../@name='UseCase'
									or ../../@name='Actor'
									or ../../@name='StateMachine'
									or ../../@name='State'
									or ../../@name='SimpleState'
									or ../../@name='CompositeState'
									or ../../@name='SubmachineState'
									or ../../@name='Pseudostate'
									or ../../@name='FinalState'
									or ../../@name='Transition'
									or ../../@name='CallEvent'
									or ../../@name='SignalEvent'
									or ../../@name='DataType'
									or ../../@name='Enumeration'">
		nameMap.put(element.getQualifiedName(), element);
		</xsl:if>
<!--
		// xmi<xsl:value-of select="translate(../../@name, '.', '_')"/>Map.put(element.getXmi_id(), element);
-->
	}
	</xsl:template>

	<xsl:template
		match="xs:element[@name and not(starts-with(@name, 'XMI'))]/xs:complexType/xs:attribute[@ref='xmi.id']"
		mode="access">
	public List&lt;org.soulspace.xmi.marshal.<xsl:value-of select="translate(../../@name, '.', '_')"/>&gt; get<xsl:value-of select="translate(../../@name, '.', '_')"/>List() {
		return xmi<xsl:value-of select="translate(../../@name, '.', '_')"/>List;
	}
	
	public Iterator&lt;org.soulspace.xmi.marshal.<xsl:value-of select="translate(../../@name, '.', '_')"/>&gt; xmi<xsl:value-of select="translate(../../@name, '.', '_')"/>ListIterator() {
		return xmi<xsl:value-of select="translate(../../@name, '.', '_')"/>List.iterator();
	}
<!--		
		Map  getXmi<xsl:value-of select="translate(../../@name, '.', '_')"/>Map() {
		  return xmi<xsl:value-of select="translate(../../@name, '.', '_')"/>Map;
		}
-->			
	</xsl:template>

	<xsl:template match="text()"/>
	<!--xsl:template match="comment()">
		/*
		<xsl:value-of select="comment()"/>
		*/
	</xsl:template-->
</xsl:stylesheet>