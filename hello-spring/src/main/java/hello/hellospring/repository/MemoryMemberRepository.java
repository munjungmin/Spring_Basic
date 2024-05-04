package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); // 실무에서는 동시성 문제가 있을 수 있어서 공유되는 변수일때는 컨커런트 해시맵을 써야함
    private static long sequence = 0L;  // 동시성 문제로 어텀롱?써야되는데 간단하게 함

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));   // null 반환 가능성
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {   // 자바에서는 실무할 때 List 많이 사용 편해서
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
