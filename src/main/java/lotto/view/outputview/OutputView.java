package lotto.view.outputview;

import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.dto.LottoDto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void outputBuyAmount(Integer ticket) {
        System.out.println();
        System.out.println(ticket + "개를 구매했습니다.");
    }

    public void outputLotto(LottoDto lottoDto) {
        List<Integer> numberDto = lottoDto.getNumberDto();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numberDto.size(); i++) {
            sb.append(numberDto.get(i));
            if (i < numberDto.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void outputPrizedRank(Map<PrizeRank, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(PrizeRank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(PrizeRank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(PrizeRank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(PrizeRank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(PrizeRank.FIRST, 0) + "개");
    }

    public void outputProfitRate(Double profitRate) {
        System.out.println(String.format("총 수익률은 %,.1f%%입니다.", profitRate));
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
