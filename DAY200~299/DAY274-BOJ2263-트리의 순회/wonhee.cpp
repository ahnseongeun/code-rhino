#include <iostream>
using namespace std;
int N;
int inOrder[100001], postOrder[100001];
int pos[100001];

//postOrder���� root�� ã�� inOrder���� �ش� ��ġ�� ������� ��������
void search(int inLeft, int inRight, int postLeft, int postRight)
{
	if (inLeft > inRight || postLeft > postRight)
		return;

	//root ã��
	int root = postOrder[postRight];
	cout << root << " ";

	//����
	search(inLeft, pos[root] - 1, postLeft, postLeft + pos[root] - inLeft - 1);
	search(pos[root] + 1, inRight, postLeft + (pos[root] - inLeft), postRight - 1);
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> inOrder[i];
		pos[inOrder[i]] = i;
	}
	for (int i = 0; i < N; i++)
		cin >> postOrder[i];

	search(0, N - 1, 0, N - 1);
	return 0;
}