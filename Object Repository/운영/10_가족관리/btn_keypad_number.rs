<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>주민번호 뒷자리 입력 키패드</description>
   <name>btn_keypad_number</name>
   <tag></tag>
   <elementGuidId>1be21f46-80b2-4142-b4a6-6bd480db2044</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>380a991c-29a0-45fd-bb05-73c002669fd4</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>988835eb-fd2a-49d9-a6d4-2bb432d3fed8</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
