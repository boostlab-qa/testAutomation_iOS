<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>우아키 > 탭 선택 상태</description>
   <name>btn_tab_selected</name>
   <tag></tag>
   <elementGuidId>88937c9a-07e0-469d-b49d-2a712fef6e9f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>dfe25e86-18e3-492c-89e4-29e68b1df352</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>5220212f-178a-453d-84b2-fce200c636a1</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>selected</name>
      <type>Main</type>
      <value>true</value>
      <webElementGuid>2f565013-c31e-49ea-9649-dcb340bc749c</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}') and @selected = 'true']</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
