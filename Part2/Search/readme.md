# 탐색(Search)

---
## 순차 탐색(Sequential Search)
- 리스트 안에 있는 특정한 데이터를 찾기 위해 **앞에서부터 데이터를 하나씩 차례대로 확인하는 방법**이다.
- 보통 **정렬되지 않은 리스트에서 데이터를 찾아야 할 때 사용**한다.
- 리스트의 특정 값의 원소가 있는지, 특정한 값을 가지는 원소의 개수를 세는 **count() 메소드는 순차 탐색**을 이용한다.

---
## 이진 탐색(Binary Search)
- 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘, **데이터가 무작위면 사용 불가**
- **탐색 범위를 절반씩 좁혀**가며 데이터를 탐색
- **찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교**해서 원하는 데이터를 찾는 것

### 시간복잡도는 O(logN)

---
## 트리(Tree)
- 그래프 자료구조의 일종으로 데이터베이스 시스템이나 파일 시스템과 같은 곳에서 **많은 양의 데이터를 관리하기 위한 목적으로 사용**한다.
### 특징
- 트리는 **부모 노드와 자식 노드의 관계로 표현**된다.
- 트리의 **최상단 노드를 루트 노드**라고 한다.
- 트리의 **최하단 노드를 단말 노드(리프 노드)** 라고 한다.
- 트리에서 **일부를 떼어내도 트리 구조이며 이를 서브 트리**라고 한다.
- 트리는 파일 시스템과 같이 계층적이고 **정렬된 데이터를 다루기에 적합**하다.

---
## 이진 탐색 트리(Binary Search Tree)
- 이진 탐색이 동작할 수 있도록 고안된, 효율적인 탐색이 가능한 자료구조
### 특징
- 부모 노드보다 왼쪽 자식 노드가 작다.
- 부모 노드보다 오른쪽 자식 노드가 크다.
- **왼쪽 자식 노드 < 부모 노드 < 오른쪽 자식 노드**

---

## 파라메트릭 서치(Parametric Search)
- 최적화 문제를 결정 문제로 바꾸어 해결하는 기법
- **결정 문제** : '예' or '아니오' 로 답하는 문제
- **원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제에 사용한다.**
- 
