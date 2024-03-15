import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

// 실행할 CMD 명령어
def command = "adb shell screenrecord --time-limit 77 --output-format mp4 --size 1080x2640 --bit-rate 5000000 /sdcard/02_컨텐츠.mp4"

// 명령어 실행
def processBuilder = new ProcessBuilder(command.split())
def process = processBuilder.start()

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - [동네 인기 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('운영/03_홈/02_contents/txt_local_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동되고 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 검색어 입력 영역에 "인기 많은 똑닥 병원" 검색어가 노출된다.'
Mobile.verifyElementText(findTestObject('운영/07_검색/input_search'), '인기 많은 똑닥 병원', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - sort filter에 "인기순"이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_sort_type', [('text') : '인기순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/02_contents/txt_local_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [지금 문연 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('운영/03_홈/02_contents/txt_open_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동되고 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색어 입력 영역에 "지금문연병원" 검색어가 노출된다.'
Mobile.verifyElementText(findTestObject('운영/07_검색/input_search'), '지금문연병원', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - sort filter에 "관련순"이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_sort_type', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [진료중] 필터가 on 상태로 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/btn_filter_open_on'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/02_contents/txt_open_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 컨텐츠 (진료과로 병원 찾기) 아이콘 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('운영/03_홈/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.waitTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.scrollToText('진료과로 병원 찾기 🏥')
}

'STEP - 홈 추천 컨텐츠 선택'
Mobile.tap(findTestObject('운영/03_홈/02_contents/btn_frame_image_section'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 우아키 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/13_우아키/tv_title', [('text') : '우리아이 키∙몸무게']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 키 탭이 선택 상태로 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/13_우아키/btn_tab_selected', [('text') : '키']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 우아키 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/13_우아키/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 소개 페이지 뒤로가기 key 선택'
Mobile.pressBack()

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('소아청소년과')

'STEP - [소아청소년과] 진료과 컨텐츠 선택'
Mobile.tap(findTestObject('운영/03_홈/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동되고 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색어 입력 영역에 "소아청소년과" 검색어가 노출된다.'
Mobile.verifyElementText(findTestObject('운영/07_검색/input_search'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [진료과목] 필터에 "소아청소년과" 필터명이 노출된다.'
Mobile.verifyElementText(findTestObject('운영/07_검색/btn_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - sort filter에 "관련순"이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_sort_type', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 목록 대표진료과목 영역에 "소아청소년과"가 노출된다.'
Mobile.verifyElementText(findTestObject('운영/07_검색/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('똑닥 예약 병원')

'STEP - [똑닥 예약 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('운영/03_홈/02_contents/txt_like_hospital_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동되고 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 검색어 입력 영역에 "똑닥 예약 병원" 검색어가 노출된다.'
Mobile.verifyElementText(findTestObject('운영/07_검색/input_search'), '똑닥 예약 병원', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - sort filter에 "관련순"이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_sort_type', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/02_contents/txt_like_hospital_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [영유아 검진 예약하기] 컨텐츠 선택'
Mobile.tap(findTestObject('운영/03_홈/02_contents/img_infant_check-up'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동되고 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색어 입력 영역에 "영유아검진" 검색어가 노출된다.'
Mobile.verifyElementText(findTestObject('운영/07_검색/input_search'), '영유아검진', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 목록에 "영유아검진" 뱃지가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_badge', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - sort filter에 "관련순"이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/07_검색/txt_sort_type', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/02_contents/img_infant_check-up'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}

// 실행 결과 확인
def reader = new BufferedReader(new InputStreamReader(process.inputStream))
def line
while ((line = reader.readLine()) != null) {
	println(line)
}