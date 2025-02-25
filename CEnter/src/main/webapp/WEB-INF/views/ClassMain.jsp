<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>학습 가능한 과목</title>
    <style>
        .hidden { display: none; } /* 기본적으로 숨김 */
    </style>
</head>
<body>
    <h1>학습 가능한 과목</h1>
    <ul>
        <li><a href="#" onclick="showDetails('java')">Java</a></li>
        <li><a href="#" onclick="showDetails('python')">Python</a></li>
        <li><a href="#" onclick="showDetails('html')">HTML</a></li>
        <li><a href="#" onclick="showDetails('javascript')">JavaScript</a></li>
        <li><a href="#" onclick="showDetails('c')">C언어</a></li>
    </ul>

    <!-- Java 학습 내용 -->
    <div id="javaDetails" class="hidden">
        <h2>Java 학습 내용</h2>
        <ul>
            <li><a href="#" onclick="showLesson('java', 'strings')">문자열</a></li>
            <li><a href="#" onclick="showLesson('java', 'conditions')">조건문</a></li>
            <li><a href="#" onclick="showLesson('java', 'loops')">반복문</a></li>
        </ul>
    </div>

    <!-- Python 학습 내용 -->
    <div id="pythonDetails" class="hidden">
        <h2>Python 학습 내용</h2>
        <ul>
            <li><a href="#" onclick="showLesson('python', 'strings')">문자열</a></li>
            <li><a href="#" onclick="showLesson('python', 'conditions')">조건문</a></li>
            <li><a href="#" onclick="showLesson('python', 'loops')">반복문</a></li>
        </ul>
    </div>

    <!-- HTML 학습 내용 -->
    <div id="htmlDetails" class="hidden">
        <h2>HTML 학습 내용</h2>
        <ul>
            <li><a href="#" onclick="showLesson('html', 'elements')">HTML 요소</a></li>
        </ul>
    </div>

    <!-- JavaScript 학습 내용 -->
    <div id="javascriptDetails" class="hidden">
        <h2>JavaScript 학습 내용</h2>
        <ul>
            <li><a href="#" onclick="showLesson('javascript', 'functions')">함수</a></li>
        </ul>
    </div>

    <!-- C 학습 내용 -->
    <div id="cDetails" class="hidden">
        <h2>C언어 학습 내용</h2>
        <ul>
            <li><a href="#" onclick="showLesson('c', 'pointers')">포인터</a></li>
        </ul>
    </div>

    <!-- 학습 세부 내용 표시 영역 -->
    <div id="lessonContent" class="hidden">
        <h2 id="lessonTitle"></h2>
        <p id="lessonDescription"></p>
    </div>

    <script>
        function showDetails(subject) {
            // 모든 세부 내용을 숨기기
            document.querySelectorAll('.hidden').forEach(el => el.style.display = 'none');
            
            // 선택한 과목의 세부 내용 보이기
            document.getElementById(subject + 'Details').style.display = 'block';
        }

        function showLesson(subject, topic) {
            const lessons = {
                java: {
                    strings: { title: "Java 문자열", description: "Java에서 문자열을 다루는 방법을 학습합니다." },
                    conditions: { title: "Java 조건문", description: "if, switch문을 학습합니다." },
                    loops: { title: "Java 반복문", description: "for, while, do-while을 학습합니다." }
                },
                python: {
                    strings: { title: "Python 문자열", description: "Python에서 문자열을 다루는 방법을 학습합니다." },
                    conditions: { title: "Python 조건문", description: "if, elif, else 문을 학습합니다." },
                    loops: { title: "Python 반복문", description: "for, while 문을 학습합니다." }
                },
                html: {
                    elements: { title: "HTML 요소", description: "HTML의 다양한 요소와 구조를 학습합니다." }
                },
                javascript: {
                    functions: { title: "JavaScript 함수", description: "JavaScript에서 함수 사용법을 학습합니다." }
                },
                c: {
                    pointers: { title: "C언어 포인터", description: "C 언어에서 포인터 개념을 학습합니다." }
                }
            };

            // 학습 내용 표시
            const lesson = lessons[subject][topic];
            document.getElementById("lessonTitle").innerText = lesson.title;
            document.getElementById("lessonDescription").innerText = lesson.description;
            document.getElementById("lessonContent").style.display = 'block';
        }
    </script>
</body>
</html>
