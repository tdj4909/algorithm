import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Cctv {
    int x;
    int y;
    int num;

    public Cctv(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] office;
    static ArrayList<Cctv> cctvs;
    static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                office[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] != 0 && office[i][j] != 6) {
                    cctvs.add(new Cctv(i, j, office[i][j]));
                }
            }
        }

        bt(0);

        System.out.println(cnt);
    }

    static void bt(int n) {
        if (n == cctvs.size()) {
            int zeroCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (office[i][j] == 0) {
                        zeroCnt++;
                    }
                }
            }

            cnt = Math.min(cnt, zeroCnt);
            return;
        }

        int x = cctvs.get(n).x;
        int y = cctvs.get(n).y;

        if (cctvs.get(n).num == 1) {
            for (int i = 0; i < 4; i++) {
                if (i == 0) { // 상
                    int ux = x;
                    while (true) {
                        ux--;
                        if (ux < 0 || office[ux][y] == 6) {
                            break;
                        } else if (office[ux][y] == 0) {
                            office[ux][y] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ux++;
                        if (ux == x) {
                            break;
                        } else if (office[ux][y] == -(n + 1)) {
                            office[ux][y] = 0;
                        }
                    }

                } else if (i == 1) { // 하
                    int dx = x;
                    while (true) {
                        dx++;
                        if (dx >= N || office[dx][y] == 6) {
                            break;
                        } else if (office[dx][y] == 0) {
                            office[dx][y] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        dx--;
                        if (dx == x) {
                            break;
                        } else if (office[dx][y] == -(n + 1)) {
                            office[dx][y] = 0;
                        }
                    }

                } else if (i == 2) { // 좌
                    int ly = y;
                    while (true) {
                        ly--;
                        if (ly < 0 || office[x][ly] == 6) {
                            break;
                        } else if (office[x][ly] == 0) {
                            office[x][ly] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ly++;
                        if (ly == y) {
                            break;
                        } else if (office[x][ly] == -(n + 1)) {
                            office[x][ly] = 0;
                        }
                    }

                } else { // 우
                    int ry = y;
                    while (true) {
                        ry++;
                        if (ry >= M || office[x][ry] == 6) {
                            break;
                        } else if (office[x][ry] == 0) {
                            office[x][ry] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ry--;
                        if (ry == y) {
                            break;
                        } else if (office[x][ry] == -(n + 1)) {
                            office[x][ry] = 0;
                        }
                    }

                }
            }
        } else if (cctvs.get(n).num == 2) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) { // 상하
                    int ux = x;
                    while (true) {
                        ux--;
                        if (ux < 0 || office[ux][y] == 6) {
                            break;
                        } else if (office[ux][y] == 0) {
                            office[ux][y] = -(n + 1);
                        }
                    }
                    int dx = x;
                    while (true) {
                        dx++;
                        if (dx >= N || office[dx][y] == 6) {
                            break;
                        } else if (office[dx][y] == 0) {
                            office[dx][y] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ux++;
                        if (ux == x) {
                            break;
                        } else if (office[ux][y] == -(n + 1)) {
                            office[ux][y] = 0;
                        }
                    }
                    while (true) {
                        dx--;
                        if (dx == x) {
                            break;
                        } else if (office[dx][y] == -(n + 1)) {
                            office[dx][y] = 0;
                        }
                    }

                } else { // 좌우
                    int ly = y;
                    while (true) {
                        ly--;
                        if (ly < 0 || office[x][ly] == 6) {
                            break;
                        } else if (office[x][ly] == 0) {
                            office[x][ly] = -(n + 1);
                        }
                    }
                    int ry = y;
                    while (true) {
                        ry++;
                        if (ry >= M || office[x][ry] == 6) {
                            break;
                        } else if (office[x][ry] == 0) {
                            office[x][ry] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ly++;
                        if (ly == y) {
                            break;
                        } else if (office[x][ly] == -(n + 1)) {
                            office[x][ly] = 0;
                        }
                    }
                    while (true) {
                        ry--;
                        if (ry == y) {
                            break;
                        } else if (office[x][ry] == -(n + 1)) {
                            office[x][ry] = 0;
                        }
                    }

                }
            }
        } else if (cctvs.get(n).num == 3) {
            for (int i = 0; i < 4; i++) {
                if (i == 0) { // 상우
                    int ux = x;
                    while (true) {
                        ux--;
                        if (ux < 0 || office[ux][y] == 6) {
                            break;
                        } else if (office[ux][y] == 0) {
                            office[ux][y] = -(n + 1);
                        }
                    }
                    int ry = y;
                    while (true) {
                        ry++;
                        if (ry >= M || office[x][ry] == 6) {
                            break;
                        } else if (office[x][ry] == 0) {
                            office[x][ry] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ux++;
                        if (ux == x) {
                            break;
                        } else if (office[ux][y] == -(n + 1)) {
                            office[ux][y] = 0;
                        }
                    }
                    while (true) {
                        ry--;
                        if (ry == y) {
                            break;
                        } else if (office[x][ry] == -(n + 1)) {
                            office[x][ry] = 0;
                        }
                    }

                } else if (i == 1) { // 하우
                    int dx = x;
                    while (true) {
                        dx++;
                        if (dx >= N || office[dx][y] == 6) {
                            break;
                        } else if (office[dx][y] == 0) {
                            office[dx][y] = -(n + 1);
                        }
                    }
                    int ry = y;
                    while (true) {
                        ry++;
                        if (ry >= M || office[x][ry] == 6) {
                            break;
                        } else if (office[x][ry] == 0) {
                            office[x][ry] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        dx--;
                        if (dx == x) {
                            break;
                        } else if (office[dx][y] == -(n + 1)) {
                            office[dx][y] = 0;
                        }
                    }
                    while (true) {
                        ry--;
                        if (ry == y) {
                            break;
                        } else if (office[x][ry] == -(n + 1)) {
                            office[x][ry] = 0;
                        }
                    }

                } else if (i == 2) { // 하좌
                    int dx = x;
                    while (true) {
                        dx++;
                        if (dx >= N || office[dx][y] == 6) {
                            break;
                        } else if (office[dx][y] == 0) {
                            office[dx][y] = -(n + 1);
                        }
                    }
                    int ly = y;
                    while (true) {
                        ly--;
                        if (ly < 0 || office[x][ly] == 6) {
                            break;
                        } else if (office[x][ly] == 0) {
                            office[x][ly] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        dx--;
                        if (dx == x) {
                            break;
                        } else if (office[dx][y] == -(n + 1)) {
                            office[dx][y] = 0;
                        }
                    }
                    while (true) {
                        ly++;
                        if (ly == y) {
                            break;
                        } else if (office[x][ly] == -(n + 1)) {
                            office[x][ly] = 0;
                        }
                    }

                } else { // 상좌
                    int ux = x;
                    while (true) {
                        ux--;
                        if (ux < 0 || office[ux][y] == 6) {
                            break;
                        } else if (office[ux][y] == 0) {
                            office[ux][y] = -(n + 1);
                        }
                    }
                    int ly = y;
                    while (true) {
                        ly--;
                        if (ly < 0 || office[x][ly] == 6) {
                            break;
                        } else if (office[x][ly] == 0) {
                            office[x][ly] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ux++;
                        if (ux == x) {
                            break;
                        } else if (office[ux][y] == -(n + 1)) {
                            office[ux][y] = 0;
                        }
                    }
                    while (true) {
                        ly++;
                        if (ly == y) {
                            break;
                        } else if (office[x][ly] == -(n + 1)) {
                            office[x][ly] = 0;
                        }
                    }

                }
            }
        } else if (cctvs.get(n).num == 4) {
            for (int i = 0; i < 4; i++) {
                if (i == 0) { // 상하우
                    int ux = x;
                    while (true) {
                        ux--;
                        if (ux < 0 || office[ux][y] == 6) {
                            break;
                        } else if (office[ux][y] == 0) {
                            office[ux][y] = -(n + 1);
                        }
                    }
                    int dx = x;
                    while (true) {
                        dx++;
                        if (dx >= N || office[dx][y] == 6) {
                            break;
                        } else if (office[dx][y] == 0) {
                            office[dx][y] = -(n + 1);
                        }
                    }
                    int ry = y;
                    while (true) {
                        ry++;
                        if (ry >= M || office[x][ry] == 6) {
                            break;
                        } else if (office[x][ry] == 0) {
                            office[x][ry] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ux++;
                        if (ux == x) {
                            break;
                        } else if (office[ux][y] == -(n + 1)) {
                            office[ux][y] = 0;
                        }
                    }
                    while (true) {
                        dx--;
                        if (dx == x) {
                            break;
                        } else if (office[dx][y] == -(n + 1)) {
                            office[dx][y] = 0;
                        }
                    }
                    while (true) {
                        ry--;
                        if (ry == y) {
                            break;
                        } else if (office[x][ry] == -(n + 1)) {
                            office[x][ry] = 0;
                        }
                    }

                } else if (i == 1) { // 하좌우
                    int ly = y;
                    while (true) {
                        ly--;
                        if (ly < 0 || office[x][ly] == 6) {
                            break;
                        } else if (office[x][ly] == 0) {
                            office[x][ly] = -(n + 1);
                        }
                    }
                    int dx = x;
                    while (true) {
                        dx++;
                        if (dx >= N || office[dx][y] == 6) {
                            break;
                        } else if (office[dx][y] == 0) {
                            office[dx][y] = -(n + 1);
                        }
                    }
                    int ry = y;
                    while (true) {
                        ry++;
                        if (ry >= M || office[x][ry] == 6) {
                            break;
                        } else if (office[x][ry] == 0) {
                            office[x][ry] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ly++;
                        if (ly == y) {
                            break;
                        } else if (office[x][ly] == -(n + 1)) {
                            office[x][ly] = 0;
                        }
                    }
                    while (true) {
                        dx--;
                        if (dx == x) {
                            break;
                        } else if (office[dx][y] == -(n + 1)) {
                            office[dx][y] = 0;
                        }
                    }
                    while (true) {
                        ry--;
                        if (ry == y) {
                            break;
                        } else if (office[x][ry] == -(n + 1)) {
                            office[x][ry] = 0;
                        }
                    }

                } else if (i == 2) { // 상하좌
                    int ux = x;
                    while (true) {
                        ux--;
                        if (ux < 0 || office[ux][y] == 6) {
                            break;
                        } else if (office[ux][y] == 0) {
                            office[ux][y] = -(n + 1);
                        }
                    }
                    int dx = x;
                    while (true) {
                        dx++;
                        if (dx >= N || office[dx][y] == 6) {
                            break;
                        } else if (office[dx][y] == 0) {
                            office[dx][y] = -(n + 1);
                        }
                    }
                    int ly = y;
                    while (true) {
                        ly--;
                        if (ly < 0 || office[x][ly] == 6) {
                            break;
                        } else if (office[x][ly] == 0) {
                            office[x][ly] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ux++;
                        if (ux == x) {
                            break;
                        } else if (office[ux][y] == -(n + 1)) {
                            office[ux][y] = 0;
                        }
                    }
                    while (true) {
                        dx--;
                        if (dx == x) {
                            break;
                        } else if (office[dx][y] == -(n + 1)) {
                            office[dx][y] = 0;
                        }
                    }
                    while (true) {
                        ly++;
                        if (ly == y) {
                            break;
                        } else if (office[x][ly] == -(n + 1)) {
                            office[x][ly] = 0;
                        }
                    }

                } else { // 상좌우
                    int ly = y;
                    while (true) {
                        ly--;
                        if (ly < 0 || office[x][ly] == 6) {
                            break;
                        } else if (office[x][ly] == 0) {
                            office[x][ly] = -(n + 1);
                        }
                    }
                    int ux = x;
                    while (true) {
                        ux--;
                        if (ux < 0 || office[ux][y] == 6) {
                            break;
                        } else if (office[ux][y] == 0) {
                            office[ux][y] = -(n + 1);
                        }
                    }
                    int ry = y;
                    while (true) {
                        ry++;
                        if (ry >= M || office[x][ry] == 6) {
                            break;
                        } else if (office[x][ry] == 0) {
                            office[x][ry] = -(n + 1);
                        }
                    }

                    bt(n + 1);

                    while (true) {
                        ly++;
                        if (ly == y) {
                            break;
                        } else if (office[x][ly] == -(n + 1)) {
                            office[x][ly] = 0;
                        }
                    }
                    while (true) {
                        ux++;
                        if (ux == x) {
                            break;
                        } else if (office[ux][y] == -(n + 1)) {
                            office[ux][y] = 0;
                        }
                    }
                    while (true) {
                        ry--;
                        if (ry == y) {
                            break;
                        } else if (office[x][ry] == -(n + 1)) {
                            office[x][ry] = 0;
                        }
                    }

                }
            }
        } else {
            int ux = x;
            while (true) {
                ux--;
                if (ux < 0 || office[ux][y] == 6) {
                    break;
                } else if (office[ux][y] == 0) {
                    office[ux][y] = -(n + 1);
                }
            }
            int dx = x;
            while (true) {
                dx++;
                if (dx >= N || office[dx][y] == 6) {
                    break;
                } else if (office[dx][y] == 0) {
                    office[dx][y] = -(n + 1);
                }
            }
            int ly = y;
            while (true) {
                ly--;
                if (ly < 0 || office[x][ly] == 6) {
                    break;
                } else if (office[x][ly] == 0) {
                    office[x][ly] = -(n + 1);
                }
            }
            int ry = y;
            while (true) {
                ry++;
                if (ry >= M || office[x][ry] == 6) {
                    break;
                } else if (office[x][ry] == 0) {
                    office[x][ry] = -(n + 1);
                }
            }

            bt(n + 1);

            while (true) {
                ux++;
                if (ux == x) {
                    break;
                } else if (office[ux][y] == -(n + 1)) {
                    office[ux][y] = 0;
                }
            }
            while (true) {
                dx--;
                if (dx == x) {
                    break;
                } else if (office[dx][y] == -(n + 1)) {
                    office[dx][y] = 0;
                }
            }
            while (true) {
                ly++;
                if (ly == y) {
                    break;
                } else if (office[x][ly] == -(n + 1)) {
                    office[x][ly] = 0;
                }
            }
            while (true) {
                ry--;
                if (ry == y) {
                    break;
                } else if (office[x][ry] == -(n + 1)) {
                    office[x][ry] = 0;
                }
            }
        }

    }

}