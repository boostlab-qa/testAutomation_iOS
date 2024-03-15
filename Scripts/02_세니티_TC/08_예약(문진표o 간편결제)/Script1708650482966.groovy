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
import java.time.LocalDate;
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

//STEP01 - 병드민 영유아문진표 On 설정 후 토스페이 예약 신청
'STEP - 병드민 설정 테스트케이스 불러오기'
Mobile.callTestCase(findTestCase('00_병드민설정_세니티/03_병드민_세니티_예약(문진o)'), [:])

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지 [수정] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '로그아웃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('테스트/02_로그인/input_etEmail'), 'qa20@qa.com', GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('테스트/02_로그인/input_etPassword'), GlobalVariable.pw, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP- [홈] 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('테스트/03_홈/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('테스트/07_검색/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 상세화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/08_병원상세/txt_tv_title', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [시간예약] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/08_병원상세/btn_large', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [시간예약] 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_large', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 패널티 팝업이 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('운영/09_접수/btn_panalty'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
Mobile.tap(findTestObject('운영/09_접수/btn_panalty'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료대상 [영유아검진] 선택'
Mobile.tap(findTestObject('테스트/09_접수/txt_name', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 가족 접수 알림 팝업 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/00_공통/btn_confirmBtn'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	Mobile.tap(findTestObject('테스트/00_공통/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('테스트/09_접수/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주민등록 뒷자리 미입력 상태인 경우 뒷자리 입력'
if(Mobile.waitForElementPresent(findTestObject('테스트/09_접수/txt_transmission_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - 주민번호 뒷자리 선택'
	Mobile.tap(findTestObject('테스트/09_접수/input_back_number'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 주민번호 뒷자리 "4444444" 입력'
	for(i = 1; i <= 7; i++)
	{
		Mobile.tap(findTestObject('테스트/10_가족관리/btn_keypad_number', [('text') : '4']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	'STEP - [입력 완료] 버튼 선택'
	Mobile.tap(findTestObject('테스트/09_접수/btn_finish'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료실 선택'
Mobile.tap(findTestObject('테스트/09_접수/txt_name', [('text') : '진료실']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 공지 노출 시 팝업 닫기'
if(Mobile.waitForElementPresent(findTestObject('테스트/00_공통/txt_tvConfirm'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('테스트/00_공통/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료항목 영유아검진 선택'
Mobile.tap(findTestObject('테스트/09_접수/txt_infant'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 하단 결제수단 영역이 노출된면 결제수단 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/00_공통/txt_tvTitle', [('text') : '결제수단']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 결제수단 영역 선택'
	Mobile.tap(findTestObject('테스트/00_공통/txt_tvTitle', [('text') : '결제수단']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
	'STEP - 간편결제 선택'
	Mobile.tap(findTestObject('테스트/09_접수/btn_tvPaymentTitle', [('text') : 'KB국민은행']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('테스트/00_공통/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('테스트/09_접수/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 현재일 정의'
LocalDate now = LocalDate.now()
int today = now.getDayOfMonth()
int tomorrow = today + 1

'STEP - 예약 스케쥴 화면에서 오늘 날짜 선택'
Mobile.tap(findTestObject('테스트/09_접수/btn_day', [('text') : today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 오늘 예약 불가능한 경우 내일 날짜 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/09_접수/txt_tv_reservation_time_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == false)
{
	'STEP - 다음 날짜 선택'
	Mobile.tap(findTestObject('테스트/09_접수/btn_day', [('text') : tomorrow]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 예약 시간 선택'
Mobile.tap(findTestObject('테스트/09_접수/txt_reservation_minute'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'예약 날짜 시간 저장'
reservation = Mobile.getText(findTestObject('테스트/09_접수/txt_reservation_time'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('테스트/09_접수/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 결제수단 선택 화면이 노출되는 경우 간편결제 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/09_접수/btn_tvPaymentTitle', [('text') : 'KB국민은행']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - 결제수단 선택 화면에서 간편결제 선택'
	Mobile.tap(findTestObject('테스트/09_접수/btn_tvPaymentTitle', [('text') : 'KB국민은행']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [다음] 버튼 선택'
	Mobile.tap(findTestObject('테스트/09_접수/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 예약완료 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/09_접수/btn_complete_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [동의하고 예약하기] 버튼 선택'
Mobile.tap(findTestObject('테스트/09_접수/btn_complete_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 영유아 검진 문진표 작성 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '영유아 검진 문진표 작성']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 문진표에 영유아검진 개월수가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/10_가족관리/txt_titleTxt_infant'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 진료카드 영역이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_cv_medical_status_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 진료카드 영역에 [영유아검진 작성] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_left', [('text') : '영유아검진 작성']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 진료카드 영역에 [사전문진 작성] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_right', [('text') : '사전문진 작성']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료카드 영역 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_cv_medical_status_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '진료내역 상세']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [영유아검진 작성] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/btn_commonBtnTitle', [('text') : '영유아검진 작성']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 환자명이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/09_접수/txt_name', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 병원명이 노출된다.'
Mobile.verifyElementText(findTestObject('테스트/04_접수내역/txt_tvHospitalTitle'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 예약일이 노출된다.'
reservation_complete = Mobile.getText(findTestObject('테스트/04_접수내역/txt_receipt_day'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyEqual(reservation, '-' + reservation_complete, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 진료실명이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_office', [('text') : '진료실']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 진료항목이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_tvSymptomTxt', [('text') : '영유아검진']),  GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 결제정보 영역에 간편결제 정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_methodValue', [('text') : '자동결제(토스페이)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 결제정보 영역에 간편결제 카드 정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/09_접수/txt_methodAdditionalInfo', [('text') : 'KB국민은행 / 계좌']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 확인 팝업에서 [예약취소] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [예약취소] 버튼이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/04_접수내역/btn_detail_reservation_cancel'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료내역 상세 화면에서 [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}