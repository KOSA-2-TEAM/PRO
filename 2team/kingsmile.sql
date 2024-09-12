select * from Users;
select * from Theme;
select * from travel_board;

select u1_0.user_idx,
       u1_0.authority,
       u1_0.created_at,
       u1_0.email,
       u1_0.nickname,
       u1_0.password,
       u1_0.phone,
       u1_0.reset_token,
       u1_0.reset_token_expiry,
       u1_0.status,
       u1_0.updated_at
from users u1_0
where u1_0.email=?
