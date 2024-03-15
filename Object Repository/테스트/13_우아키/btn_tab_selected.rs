<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>우아키 > 탭 선택 상태</description>
   <name>btn_tab_selected</name>
   <tag></tag>
   <elementGuidId>b7ec0760-5a67-455e-a463-6bc6f9f42cca</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>1664d815-85b0-4157-abb7-09581c4d69b7</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>e1e0245b-3fea-4aad-8e26-13c984607229</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>selected</name>
      <type>Main</type>
      <value>true</value>
      <webElementGuid>c6d3f51d-e031-48e2-bea6-11f200c121cb</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}') and @selected = 'true']</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
